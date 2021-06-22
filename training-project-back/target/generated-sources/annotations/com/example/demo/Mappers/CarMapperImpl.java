package com.example.demo.Mappers;

import com.example.demo.DTO.CarDTO;
import com.example.demo.Entities.CarEntity;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-06-22T17:04:21+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 14.0.2 (Private Build)"
)
@Component
public class CarMapperImpl implements CarMapper {

    @Override
    public CarDTO carDTO(CarEntity car) {
        if ( car == null ) {
            return null;
        }

        CarDTO carDTO = new CarDTO();

        if ( car.getId() != null ) {
            carDTO.setId( car.getId() );
        }
        if ( car.getBrand() != null ) {
            carDTO.setBrand( car.getBrand() );
        }
        if ( car.getModel() != null ) {
            carDTO.setModel( car.getModel() );
        }
        if ( car.getHorsePower() != null ) {
            carDTO.setHorsePower( car.getHorsePower() );
        }
        if ( car.getEngine() != null ) {
            carDTO.setEngine( car.getEngine() );
        }
        if ( car.getColor() != null ) {
            carDTO.setColor( car.getColor() );
        }
        if ( car.getMileage() != null ) {
            carDTO.setMileage( car.getMileage() );
        }
        Set<CarEntity> set = car.getTypes();
        if ( set != null ) {
            carDTO.setTypes( new HashSet<CarEntity>( set ) );
        }

        return carDTO;
    }

    @Override
    public List<CarDTO> carsDTO(List<CarEntity> cars) {
        if ( cars == null ) {
            return null;
        }

        List<CarDTO> list = new ArrayList<CarDTO>( cars.size() );
        for ( CarEntity carEntity : cars ) {
            list.add( carDTO( carEntity ) );
        }

        return list;
    }
}
