package com.mygaadi.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.mygaadi.entities.Car;

public interface CarDao extends JpaRepository<Car, Long> {
    // You can add custom methods here if needed
}
