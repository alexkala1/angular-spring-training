package com.example.demo.Controllers;

import com.example.demo.Config.Exceptions.ApiRequestException;
import com.example.demo.Config.Exceptions.RecordNotFoundException;
import com.example.demo.DTO.TypeDTO;
import com.example.demo.Entities.TypeEntity;
import com.example.demo.Services.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/types")
public class TypeController {

    @Autowired
    private TypeService service;

    @GetMapping
    public ResponseEntity<List<TypeDTO>> getAllTypes() {
        List<TypeDTO> list = service.getAllTypes();

        return new ResponseEntity<>(list, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TypeDTO> getTypeById(@PathVariable("id") Long id)
            throws ApiRequestException {
        TypeDTO type = service.getTypeById(id);

        return new ResponseEntity<>(type, new HttpHeaders(), HttpStatus.OK);
    }

    @PostMapping
    public TypeEntity createOrUpdateType(@RequestBody TypeEntity type)
            throws RecordNotFoundException {
        return service.createOrUpdateType(type);
    }

    @DeleteMapping("/{id}")
    public HttpStatus deleteTypeById(@PathVariable("id") Long id)
            throws RecordNotFoundException {
        service.deleteTypeById(id);
        return HttpStatus.FORBIDDEN;
    }
}
