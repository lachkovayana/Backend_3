package com.example.backendkt.dto.converter;

import com.example.backendkt.dto.CarDto;
import com.example.backendkt.dto.CarDtoWithoutManufacturer;
import com.example.backendkt.dto.CreateUpdateCarDto;
import com.example.backendkt.entity.CarEntity;
import com.example.backendkt.entity.ManufacturerEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class CarDtoConverter {
    public static CarEntity convertDtoToEntity(CreateUpdateCarDto dto, ManufacturerEntity manufacturer) {
        var entity = new CarEntity();
        entity.setId(UUID.randomUUID().toString());
        entity.setCarModel(dto.getCarModel());
        entity.setReleaseYear(dto.getReleaseYear());
        entity.setManufacturer(manufacturer);

        return entity;
    }

    public static List<CarDtoWithoutManufacturer> convertEntitiesToDto(List<CarEntity> carEntities) {
        List<CarDtoWithoutManufacturer> result = new ArrayList<>();
        carEntities.forEach(entity -> {
            result.add(convertEntityToDtoWithoutManufacturer(entity));
        });
        return result;
    }

    public static CarDtoWithoutManufacturer convertEntityToDtoWithoutManufacturer(CarEntity entity) {
        var dto = new CarDtoWithoutManufacturer();
        dto.setId(entity.getId());
        dto.setCarModel(entity.getCarModel());
        dto.setReleaseYear(entity.getReleaseYear());
        return dto;
    }

    public static CarDto convertEntityToDto(CarEntity entity) {
        var dto = new CarDto();
        dto.setId(entity.getId());
        dto.setCarModel(entity.getCarModel());
        dto.setReleaseYear(entity.getReleaseYear());
        dto.setManufacturer(entity.getManufacturer().getId());
        return dto;
    }
}
