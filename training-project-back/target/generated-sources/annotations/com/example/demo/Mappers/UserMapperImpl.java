package com.example.demo.Mappers;

import com.example.demo.DTO.UserDTO;
import com.example.demo.Entities.UserEntity;
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
public class UserMapperImpl implements UserMapper {

    @Override
    public UserDTO userDTO(UserEntity user) {
        if ( user == null ) {
            return null;
        }

        UserDTO userDTO = new UserDTO();

        if ( user.getId() != null ) {
            userDTO.setId( user.getId() );
        }
        if ( user.getName() != null ) {
            userDTO.setName( user.getName() );
        }
        if ( user.getSurname() != null ) {
            userDTO.setSurname( user.getSurname() );
        }
        if ( user.getEmail() != null ) {
            userDTO.setEmail( user.getEmail() );
        }
        if ( user.getPassword() != null ) {
            userDTO.setPassword( user.getPassword() );
        }

        return userDTO;
    }

    @Override
    public UserDTO loggedInUser(UserEntity user) {
        if ( user == null ) {
            return null;
        }

        UserDTO userDTO = new UserDTO();

        if ( user.getId() != null ) {
            userDTO.setId( user.getId() );
        }
        if ( user.getName() != null ) {
            userDTO.setName( user.getName() );
        }
        if ( user.getSurname() != null ) {
            userDTO.setSurname( user.getSurname() );
        }
        if ( user.getEmail() != null ) {
            userDTO.setEmail( user.getEmail() );
        }

        return userDTO;
    }

    @Override
    public List<UserDTO> userListDTO(List<UserEntity> userList) {
        if ( userList == null ) {
            return null;
        }

        List<UserDTO> list = new ArrayList<UserDTO>( userList.size() );
        for ( UserEntity userEntity : userList ) {
            list.add( userDTO( userEntity ) );
        }

        return list;
    }
}
