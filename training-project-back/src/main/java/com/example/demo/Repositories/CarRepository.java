package com.example.demo.Repositories;

import com.example.demo.Entities.CarEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository
        extends JpaRepository<CarEntity, Long> {

}

