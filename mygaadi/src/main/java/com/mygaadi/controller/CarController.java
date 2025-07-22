package com.mygaadi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.mygaadi.dto.CarRequestDTO;
import com.mygaadi.dto.CarResponseDTO;
import com.mygaadi.service.CarService;

@RestController
@RequestMapping("/cars")
public class CarController {

    @Autowired
    private CarService carService;

    @PostMapping("/add")
    public ResponseEntity<CarResponseDTO> addCar(@RequestBody CarRequestDTO dto) {
        CarResponseDTO savedCar = carService.addCar(dto);
        return ResponseEntity.ok(savedCar);
    }
}
