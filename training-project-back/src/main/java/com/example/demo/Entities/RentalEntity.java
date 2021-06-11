package com.example.demo.Entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "rentals")

public class RentalEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "from")
    private Date from;

    @Column(name = "to")
    private Date to;

    @Column(name = "price")
    private float price;

    @ManyToOne
    @JoinColumn(name="user_id")
    @JsonManagedReference
    private long user_id;
}
