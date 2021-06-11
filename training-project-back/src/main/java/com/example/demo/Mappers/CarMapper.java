package com.example.demo.Mappers;

import com.example.demo.DTO.CarDTO;
import com.example.demo.Entities.CarEntity;
import org.mapstruct.Mapper;

@Mapper
public interface CarMapper {
    CarDTO carDTO(CarEntity car);

}
