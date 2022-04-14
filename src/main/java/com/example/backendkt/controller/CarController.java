package com.example.backendkt.controller;

import com.example.backendkt.dto.CarDto;
import com.example.backendkt.dto.CreateUpdateCarDto;
import com.example.backendkt.dto.FetchCarDto;
import com.example.backendkt.service.CarService;
import com.example.backendkt.service.ManufacturerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/cars")
@RequiredArgsConstructor
public class CarController {
    private final CarService carService;
    private final ManufacturerService manufacturerService;

    @PostMapping
    public CarDto save(@RequestBody CreateUpdateCarDto createUpdateCarDto) {
        return carService.save(createUpdateCarDto);
    }

    @PostMapping("/init")
    public void initCsv() {
        manufacturerService.initCsv();
        carService.initCsv();
    }

    @GetMapping("/{id}")
    public CarDto getById(@PathVariable UUID id) {
        return carService.getDtoById(id.toString());
    }

    @GetMapping("/fetch")
    public List<CarDto> getById(@RequestBody FetchCarDto dto) {
        return carService.fetchCars(dto);
    }

}
