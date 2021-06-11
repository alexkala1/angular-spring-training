package com.example.demo.Mappers;

import com.example.demo.DTO.UserDTO;
import com.example.demo.Entities.UserEntity;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-06-11T15:05:29+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 14.0.2 (Private Build)"
)
public class UserMapperImpl implements UserMapper {

    @Override
    public UserDTO userDTO(UserEntity user) {
        if ( user == null ) {
            return null;
        }

        UserDTO userDTO = new UserDTO();

        return userDTO;
    }
}
