package com.example.demo.Mappers;

import com.example.demo.DTO.CarDTO;
import com.example.demo.Entities.CarEntity;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;

@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface CarMapper {
    CarDTO carDTO(CarEntity car);

    List<CarDTO> carsDTO(List<CarEntity> cars);
}
