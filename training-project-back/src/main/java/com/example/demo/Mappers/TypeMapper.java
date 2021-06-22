package com.example.demo.Mappers;

import com.example.demo.DTO.TypeDTO;

import com.example.demo.Entities.TypeEntity;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;

@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface TypeMapper {
    TypeDTO typeDTO(TypeEntity type);

    List<TypeDTO> types(List<TypeEntity> type);
}