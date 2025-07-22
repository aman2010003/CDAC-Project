package com.mygaadi.service;

import com.mygaadi.dto.CarRequestDTO;
import com.mygaadi.dto.CarResponseDTO;

public interface CarService {
    CarResponseDTO addCar(CarRequestDTO dto);
}
