package com.example.demo.Mappers;

import com.example.demo.DTO.RentalDTO;
import com.example.demo.Entities.RentalEntity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-06-23T09:47:24+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 14.0.2 (Private Build)"
)
@Component
public class RentalMapperImpl implements RentalMapper {

    @Override
    public RentalDTO rentalDTO(RentalEntity rental) {
        if ( rental == null ) {
            return null;
        }

        RentalDTO rentalDTO = new RentalDTO();

        if ( rental.getId() != null ) {
            rentalDTO.setId( rental.getId() );
        }
        if ( rental.getPrice() != null ) {
            rentalDTO.setPrice( rental.getPrice() );
        }

        return rentalDTO;
    }

    @Override
    public List<RentalDTO> rentals(List<RentalEntity> rental) {
        if ( rental == null ) {
            return null;
        }

        List<RentalDTO> list = new ArrayList<RentalDTO>( rental.size() );
        for ( RentalEntity rentalEntity : rental ) {
            list.add( rentalDTO( rentalEntity ) );
        }

        return list;
    }
}
