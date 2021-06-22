package com.example.demo.Mappers;

import com.example.demo.DTO.TypeDTO;
import com.example.demo.Entities.TypeEntity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-06-22T17:04:21+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 14.0.2 (Private Build)"
)
@Component
public class TypeMapperImpl implements TypeMapper {

    @Override
    public TypeDTO typeDTO(TypeEntity type) {
        if ( type == null ) {
            return null;
        }

        TypeDTO typeDTO = new TypeDTO();

        if ( type.getId() != null ) {
            typeDTO.setId( type.getId() );
        }
        if ( type.getName() != null ) {
            typeDTO.setName( type.getName() );
        }

        return typeDTO;
    }

    @Override
    public List<TypeDTO> types(List<TypeEntity> type) {
        if ( type == null ) {
            return null;
        }

        List<TypeDTO> list = new ArrayList<TypeDTO>( type.size() );
        for ( TypeEntity typeEntity : type ) {
            list.add( typeDTO( typeEntity ) );
        }

        return list;
    }
}
