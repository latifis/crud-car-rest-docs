package com.techno.car.controller;

import com.techno.car.entity.CarEntity;
import com.techno.car.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/cars")
public class CarController {

    @Autowired
    private CarService carService;

    @GetMapping
    public List<CarEntity> getAllCars() {
        return carService.getAllCars();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CarEntity> getCarById(
            @PathVariable Long id
    ) {
        Optional<CarEntity> car = carService.getCarById(id);
        if (car.isPresent()) {
            return new ResponseEntity<>(car.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public CarEntity addCar(
            @RequestBody CarEntity car
    ) {
        return carService.addCar(car);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CarEntity> updateCar(
            @PathVariable Long id,
            @RequestBody CarEntity carDetails
    ) {
        try {
            CarEntity updatedCar = carService.updateCar(id, carDetails);
            return new ResponseEntity<>(updatedCar, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCar(
            @PathVariable Long id
    ) {
        carService.deleteCar(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
