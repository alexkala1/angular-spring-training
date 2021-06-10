package com.example.demo.Controllers;

import com.example.demo.Config.Exceptions.RecordNotFoundException;
import com.example.demo.Entities.CarEntity;
import com.example.demo.Services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cars")
public class CarController {
    @Autowired
    CarService service;

    @GetMapping
    public ResponseEntity<List<CarEntity>> getAllCars() {
        List<CarEntity> list = service.getAllCars();

        return new ResponseEntity<>(list, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CarEntity> getCarById(@PathVariable("id") Long id)
            throws RecordNotFoundException {
        CarEntity entity = service.getCarById(id);

        return new ResponseEntity<>(entity, new HttpHeaders(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CarEntity> createOrUpdateCar(CarEntity car)
            throws RecordNotFoundException {
        CarEntity updated = service.createOrUpdateCar(car);
        return new ResponseEntity<CarEntity>(updated, new HttpHeaders(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public HttpStatus deleteCarById(@PathVariable("id") Long id)
            throws RecordNotFoundException {
        service.deleteCarById(id);
        return HttpStatus.FORBIDDEN;
    }
}
