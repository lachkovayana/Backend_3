package com.example.backendkt.dto.converter;

import com.example.backendkt.dto.CreateUpdateManufacturerDto;
import com.example.backendkt.dto.ManufacturerDto;
import com.example.backendkt.dto.ManufacturerDtoWithoutCars;
import com.example.backendkt.entity.CarEntity;
import com.example.backendkt.entity.ManufacturerEntity;

import java.util.List;
import java.util.UUID;

public class ManufacturerConverterDto {
    public static ManufacturerEntity convertDtoToEntity(CreateUpdateManufacturerDto dto) {
        ManufacturerEntity entity = new ManufacturerEntity();
        entity.setId(UUID.randomUUID().toString());
        entity.setName(dto.getName());
        return entity;
    }

    public static ManufacturerDtoWithoutCars convertEntityToDtoWithoutCars(ManufacturerEntity entity) {
        ManufacturerDtoWithoutCars dto = new ManufacturerDtoWithoutCars();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        return dto;
    }

    public static ManufacturerDto convertEntityToDtoWithCars(ManufacturerEntity entity, List<CarEntity> cars) {
        ManufacturerDto dto = new ManufacturerDto();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setCars(CarDtoConverter.convertEntitiesToDto(cars));
        return dto;
    }
}
