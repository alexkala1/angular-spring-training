package com.example.demo.Controllers;

import com.example.demo.Config.Exceptions.RecordNotFoundException;
import com.example.demo.Entities.RentalEntity;
import com.example.demo.Mappers.RentalMapper;
import com.example.demo.Services.RentalService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/rentals")
public class RentalController {

    private final RentalService service;
    private final RentalMapper rentalMapper;

    @GetMapping
    public ResponseEntity<List<RentalEntity>> getAllRentals() {
        List<RentalEntity> list = service.getAllRentals();

        return new ResponseEntity<>(list, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RentalEntity> getRentalById(@PathVariable("id") Long id)
            throws RecordNotFoundException {
        RentalEntity entity = service.getRentalById(id);

        return new ResponseEntity<>(entity, new HttpHeaders(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<RentalEntity> createRental(@RequestBody RentalEntity rental)
            throws RecordNotFoundException {
        RentalEntity created = service.createRental(rental);
        return new ResponseEntity<RentalEntity>(created, new HttpHeaders(), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<RentalEntity> updateRental(@RequestBody RentalEntity rental)
            throws RecordNotFoundException {
        RentalEntity updated = service.updateRental(rental);
        return new ResponseEntity<RentalEntity>(updated, new HttpHeaders(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public HttpStatus deleteRentalById(@PathVariable("id") Long id)
            throws RecordNotFoundException {
        service.deleteRentalById(id);
        return HttpStatus.FORBIDDEN;
    }
}
