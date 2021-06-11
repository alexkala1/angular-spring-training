package com.example.demo.Mappers;

import com.example.demo.DTO.CarDTO;
import com.example.demo.Entities.CarEntity;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-06-11T15:05:29+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 14.0.2 (Private Build)"
)
public class CarMapperImpl implements CarMapper {

    @Override
    public CarDTO carDTO(CarEntity car) {
        if ( car == null ) {
            return null;
        }

        CarDTO carDTO = new CarDTO();

        return carDTO;
    }
}
