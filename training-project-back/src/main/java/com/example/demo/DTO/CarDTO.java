package com.example.demo.DTO;

import lombok.Getter;
import lombok.Setter;

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
}
