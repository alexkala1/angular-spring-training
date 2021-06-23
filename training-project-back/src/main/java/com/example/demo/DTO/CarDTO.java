package com.example.demo.DTO;

import com.example.demo.Entities.CarEntity;
import com.example.demo.Entities.TypeEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class CarDTO {
    private Long id;
    private String brand;
    private String model;
    private Integer horsePower;
    private Integer engine;
    private String color;
    private Integer mileage;
    private Set<TypeEntity> types;
}
