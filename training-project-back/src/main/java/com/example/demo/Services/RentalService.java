package com.example.demo.Services;

import com.example.demo.Config.Exceptions.RecordNotFoundException;
import com.example.demo.Entities.RentalEntity;
import com.example.demo.Repositories.RentalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RentalService {
    @Autowired
    RentalRepository repository;

    public List<RentalEntity> getAllRentals() {
        List<RentalEntity> rentalList = repository.findAll();

        if (rentalList.size() > 0) {
            return rentalList;
        } else {
            return new ArrayList<>();
        }
    }

    public RentalEntity getRentalById(Long id) throws RecordNotFoundException {
        Optional<RentalEntity> rental = repository.findById(id);

        if (rental.isPresent()) {
            return rental.get();
        } else {
            throw new RecordNotFoundException("No rental record exist for given id");
        }
    }

    public RentalEntity createRental(RentalEntity entity) {
        return repository.save(entity);
    }

    public RentalEntity updateRental(RentalEntity entity) throws RecordNotFoundException {
        Optional<RentalEntity> rental = repository.findById(entity.getId());
        RentalEntity newEntity = rental.get();

        newEntity.setFrom(entity.getFrom());
        newEntity.setTo(entity.getTo());
        newEntity.setTotal_price(entity.getTotal_price());
        newEntity.setCars(entity.getCars());

        return newEntity;
    }

    public void deleteRentalById(Long id) throws RecordNotFoundException {
        Optional<RentalEntity> rental = repository.findById(id);

        if (rental.isPresent()) {
            repository.deleteById(id);
        } else {
            throw new RecordNotFoundException("No rental record exist for given id");
        }
    }
}
