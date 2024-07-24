package com.techno.car.service;

import com.techno.car.entity.CarEntity;

import java.util.List;
import java.util.Optional;

public interface CarService {

    List<CarEntity> getAllCars();

    Optional<CarEntity> getCarById(Long id);

    CarEntity addCar(CarEntity carEntity);

    CarEntity updateCar(Long id, CarEntity carDetails);

    void deleteCar(Long id);

}
