package com.example.demo.DTO;

import com.example.demo.Entities.RentalEntity;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UserDTO {
    private Long id;
    private String name;
    private String surname;
    private String email;
    private String password;
    private List<RentalEntity> rentals;
}
