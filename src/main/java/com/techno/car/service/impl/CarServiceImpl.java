package com.techno.car.service.impl;

import com.techno.car.entity.CarEntity;
import com.techno.car.repository.CarRepository;
import com.techno.car.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarServiceImpl implements CarService {

    @Autowired
    private CarRepository carRepository;

    @Override
    public List<CarEntity> getAllCars() {
        return carRepository.findAll();
    }

    @Override
    public Optional<CarEntity> getCarById(Long id) {
        return carRepository.findById(id);
    }

    @Override
    public CarEntity addCar(CarEntity carEntity) {
        return carRepository.save(carEntity);
    }

    @Override
    public CarEntity updateCar(Long id, CarEntity carDetails) {
        CarEntity car = carRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Car not found"));
        car.setBrand(carDetails.getBrand());
        car.setModel(carDetails.getModel());
        car.setYear(carDetails.getYear());
        return carRepository.save(car);
    }

    @Override
    public void deleteCar(Long id) {
        carRepository.deleteById(id);
    }
}
