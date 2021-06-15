package com.example.demo.Mappers;

import com.example.demo.DTO.RentalDTO;

import com.example.demo.Entities.RentalEntity;

import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;

@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface RentalMapper {
    RentalDTO rentalDTO(RentalEntity rental);

    List<RentalDTO> rentals(List<RentalEntity> rental);
}
