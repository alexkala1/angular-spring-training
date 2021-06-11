package com.example.demo.Entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name="users")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @Column(name="email", nullable=false, unique = true, length=200)
    private String email;

    @Column(name="password")
    private String password;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "User")
    @JsonManagedReference
    private List<RentalEntity> rentals;
}