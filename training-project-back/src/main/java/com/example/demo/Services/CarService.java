package com.example.demo.Services;

import com.example.demo.Config.Exceptions.RecordNotFoundException;
import com.example.demo.DTO.CarDTO;
import com.example.demo.Entities.CarEntity;
import com.example.demo.Mappers.CarMapper;
import com.example.demo.Repositories.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CarService {
    private final CarRepository repository;
    private final CarMapper carMapper;

    public List<CarDTO> getAllCars()
    {
        List<CarEntity> carList = repository.findAll();

        if(carList.size() > 0) {
            return carMapper.carsDTO(carList);
        } else {
            return new ArrayList<>();
        }
    }

    public CarDTO getCarById(Long id) throws RecordNotFoundException
    {
        Optional<CarEntity> car = repository.findById(id);

        if(car.isPresent()) {
            return carMapper.carDTO(car.get());
        } else {
            throw new RecordNotFoundException("No car record exist for given id");
        }
    }

    public CarEntity createOrUpdateCar(CarEntity entity) throws RecordNotFoundException
    {
        Optional<CarEntity> car = repository.findById(entity.getId());

        if(car.isPresent())
        {
            CarEntity newEntity = car.get();
            newEntity.setBrand(entity.getBrand());
            newEntity.setModel(entity.getModel());
            newEntity.setHorsePower(entity.getHorsePower());
            newEntity.setEngine(entity.getEngine());
            newEntity.setColor(entity.getColor());
            newEntity.setMileage(entity.getMileage());

            newEntity = repository.save(newEntity);

            return newEntity;
        } else {
            entity = repository.save(entity);

            return entity;
        }
    }

    public void deleteCarById(Long id) throws RecordNotFoundException
    {
        Optional<CarEntity> car = repository.findById(id);

        if(car.isPresent())
        {
            repository.deleteById(id);
        } else {
            throw new RecordNotFoundException("No car record exist for given id");
        }
    }
}
