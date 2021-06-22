package com.example.demo.Controllers;
import java.util.List;

import com.example.demo.Config.Exceptions.ApiRequestException;
import com.example.demo.DTO.UserDTO;
import com.example.demo.Mappers.UserMapper;
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
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        List<UserDTO> list = service.getAllUsers();

        return new ResponseEntity<>(list, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable("id") Long id)
            throws ApiRequestException {
        UserDTO user = service.getUserById(id);

        return new ResponseEntity<>(user, new HttpHeaders(), HttpStatus.OK);
    }

    @PostMapping
    public UserEntity createOrUpdateUser(@RequestBody UserEntity user)
            throws RecordNotFoundException {
        return service.createOrUpdateUser(user);
    }

    @DeleteMapping("/{id}")
    public HttpStatus deleteUserById(@PathVariable("id") Long id)
            throws RecordNotFoundException {
        service.deleteUserById(id);
        return HttpStatus.FORBIDDEN;
    }

//    login
    @PostMapping("/login")
    public UserDTO login(@RequestBody UserDTO user) throws ApiRequestException {
        return service.login(user.getEmail(), user.getPassword());
    }
}