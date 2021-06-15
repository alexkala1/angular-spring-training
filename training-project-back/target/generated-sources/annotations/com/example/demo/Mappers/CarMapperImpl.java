package com.example.demo.Mappers;

import com.example.demo.DTO.CarDTO;
import com.example.demo.Entities.CarEntity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-06-15T10:19:02+0300",
    comments = "version: 1.4.2.Final, compiler: Eclipse JDT (IDE) 1.3.1300.v20210331-0708, environment: Java 14.0.2 (Private Build)"
)
@Component
public class CarMapperImpl implements CarMapper {

    @Override
    public CarDTO carDTO(CarEntity car) {
        if ( car == null ) {
            return null;
        }

        CarDTO carDTO = new CarDTO();

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
