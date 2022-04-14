package com.example.backendkt.controller;

import com.example.backendkt.dto.CarDto;
import com.example.backendkt.dto.CreateUpdateCarDto;
import com.example.backendkt.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cars")
@RequiredArgsConstructor
public class CarController {
    private  final CarService carService;

    @PostMapping
    public CarDto save(@RequestBody CreateUpdateCarDto createUpdateCarDto) {
        return carService.createCar(createUpdateCarDto);
    }

//    @GetMapping("/{id}")

}
