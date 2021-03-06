package com.example.backendkt.controller;

import com.example.backendkt.dto.CreateUpdateManufacturerDto;
import com.example.backendkt.dto.ManufacturerDto;
import com.example.backendkt.dto.ManufacturerDtoWithoutCars;
import com.example.backendkt.service.ManufacturerService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/manufacturer")
@RequiredArgsConstructor
public class ManufacturerController {
    private final ManufacturerService manufacturerService;

    @PostMapping
    public ManufacturerDtoWithoutCars save(@Validated @RequestBody CreateUpdateManufacturerDto createUpdateProjectDto) {
        return manufacturerService.save(createUpdateProjectDto);
    }

    @GetMapping("/{id}")
    public ManufacturerDto getById(@PathVariable UUID id) {
        return manufacturerService.getDtoById(id.toString());
    }
}
