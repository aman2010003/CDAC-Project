package com.mygaadi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mygaadi.dao.CarDao;
import com.mygaadi.dao.UserDao;
import com.mygaadi.dto.CarRequestDTO;
import com.mygaadi.dto.CarResponseDTO;
import com.mygaadi.entities.Car;
import com.mygaadi.entities.User;
import com.mygaadi.custom_exceptions.ResourceNotFoundException;

import org.modelmapper.ModelMapper;

import java.time.LocalDateTime;

@Service
public class CarServiceImpl implements CarService {

    @Autowired
    private CarDao carDao;

    @Autowired
    private UserDao userDao;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public CarResponseDTO addCar(CarRequestDTO dto) {
        User seller = userDao.findById(dto.getSellerId())
                .orElseThrow(() -> new ResourceNotFoundException("User not found with ID " + dto.getSellerId()));
        
        Car car = modelMapper.map(dto, Car.class);
        car.setSeller(seller);
        car.setCreatedAt(LocalDateTime.now());

        Car saved = carDao.save(car);

        return modelMapper.map(saved, CarResponseDTO.class);
    }
}
