package com.example.demo.DTO;

import com.example.demo.Entities.CarEntity;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.Date;
import java.util.List;

@Getter
@Setter
public class RentalDTO {
    private Long id;
    private Instant rental_from;
    private Date rental_to;
    private Float total_price;
    private List<CarEntity> cars;
}
