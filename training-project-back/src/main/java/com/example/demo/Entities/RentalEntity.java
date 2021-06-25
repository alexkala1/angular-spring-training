package com.example.demo.Entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.Instant;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "rentals")

public class RentalEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "rental_from")
    private Instant from;

    @Column(name = "rental_to")
    private Date to;

    @Column(name = "total_price")
    private Float total_price;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<CarEntity> cars;
}
