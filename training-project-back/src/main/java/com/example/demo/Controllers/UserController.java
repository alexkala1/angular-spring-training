package com.example.demo.Controllers;
import java.util.List;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.Entities.UserEntity;
import com.example.demo.Config.Exceptions.RecordNotFoundException;
import com.example.demo.Services.UserService;

@RestController
@RequestMapping("/users")
public class UserController
{
    @Autowired
    private UserService service;

    @GetMapping
    public ResponseEntity<List<UserEntity>> getAllUsers() {
        List<UserEntity> list = service.getAllUsers();

        return new ResponseEntity<>(list, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserEntity> getUserById(@PathVariable("id") Long id)
            throws RecordNotFoundException {
        UserEntity entity = service.getUserById(id);

        return new ResponseEntity<>(entity, new HttpHeaders(), HttpStatus.OK);
    }

    @PostMapping
    public UserEntity createOrUpdateUser(@RequestBody UserEntity user)
            throws RecordNotFoundException {
        UserEntity updated = service.createOrUpdateUser(user);

        return updated;
//        return new ResponseEntity<UserEntity>(updated, new HttpHeaders(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public HttpStatus deleteUserById(@PathVariable("id") Long id)
            throws RecordNotFoundException {
        service.deleteUserById(id);
        return HttpStatus.FORBIDDEN;
    }
}