package com.example.demo.Services;

import com.example.demo.Config.Exceptions.RecordNotFoundException;
import com.example.demo.DTO.CarDTO;
import com.example.demo.Entities.CarEntity;
import com.example.demo.Entities.TypeEntity;
import com.example.demo.Mappers.CarMapper;
import com.example.demo.Repositories.CarRepository;
import com.example.demo.Repositories.TypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CarService {
    private final CarRepository carRepository;
    private final TypeRepository typeRepository;
    private final CarMapper carMapper;

    public List<CarDTO> getAllCars()
    {
        List<CarEntity> carList = carRepository.findAll();

        if(carList.size() > 0) {
            return carMapper.carsDTO(carList);
        } else {
            return new ArrayList<>();
        }
    }

    public CarDTO getCarById(Long id) throws RecordNotFoundException
    {
        Optional<CarEntity> car = carRepository.findById(id);

        if(car.isPresent()) {
            return carMapper.carDTO(car.get());
        } else {
            throw new RecordNotFoundException("No car record exist for given id");
        }
    }

    public CarEntity createOrUpdateCar(CarEntity entity) throws RecordNotFoundException
    {
        if(entity.getId() != null) {
            Optional<CarEntity> car = carRepository.findById(entity.getId());

            CarEntity newEntity = car.get();
            newEntity.setBrand(entity.getBrand());
            newEntity.setModel(entity.getModel());
            newEntity.setHorsePower(entity.getHorsePower());
            newEntity.setEngine(entity.getEngine());
            newEntity.setColor(entity.getColor());
            newEntity.setMileage(entity.getMileage());
            newEntity.setPrice(entity.getPrice());

            newEntity = carRepository.save(newEntity);

            return newEntity;
        } else {
            entity = carRepository.save(entity);

            return entity;
        }
    }

    public void deleteCarById(Long id) throws RecordNotFoundException
    {
        Optional<CarEntity> car = carRepository.findById(id);

        if(car.isPresent())
        {
            carRepository.deleteById(id);
        } else {
            throw new RecordNotFoundException("No car record exist for given id");
        }
    }
}
