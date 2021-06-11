package com.example.demo.Entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
@Getter
@Setter
@Entity
@Table(name="cars")
public class CarEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="brand")
    private String brand;

    @Column(name="model")
    private String model;

    @Column(name="horsePower")
    private Integer horsePower;

    @Column(name="engine")
    private Integer engine;

    @Column(name="color")
    private String color;

    @Column(name="mileage")
    private Integer mileage;
}
