package com.example.demo.Mappers;

import com.example.demo.DTO.UserDTO;
import com.example.demo.Entities.UserEntity;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE, uses = {RentalMapper.class})
public interface UserMapper {
    UserDTO userDTO(UserEntity user);

    @Named("loggedInUser")
    @Mapping(target = "password", ignore = true)
    UserDTO loggedInUser(UserEntity user);

    List<UserDTO> userListDTO(List<UserEntity> userList);
}
