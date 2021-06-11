package com.example.demo.Mappers;

import com.example.demo.DTO.UserDTO;
import com.example.demo.Entities.UserEntity;
import org.mapstruct.Mapper;

@Mapper
public interface UserMapper {
    UserDTO userDTO(UserEntity user);
}
