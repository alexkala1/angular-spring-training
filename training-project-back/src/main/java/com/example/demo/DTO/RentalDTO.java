package com.example.demo.DTO;

import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.Date;

@Getter
@Setter
public class RentalDTO {
    private Long id;
    private Instant rental_from;
    private Date rental_to;
    private Float price;
}
