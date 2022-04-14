package com.example.backendkt.service;

import com.example.backendkt.dto.CarDto;
import com.example.backendkt.dto.CreateUpdateCarDto;
import com.example.backendkt.dto.converter.CarDtoConverter;
import com.example.backendkt.entity.CarEntity;
import com.example.backendkt.entity.ManufacturerEntity;
import com.example.backendkt.exception.exceptionNotFound;
import com.example.backendkt.repository.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CarService {
    private final CarRepository carRepository;
    private final ManufacturerService manufacturerService;

    @Transactional
    public CarDto save(CreateUpdateCarDto dto) {
        ManufacturerEntity manufacturer = manufacturerService.getEntityById(dto.getManufacturer());

        CarEntity entity = CarDtoConverter.convertDtoToEntity(dto, manufacturer);
        entity = carRepository.save(entity);

        return CarDtoConverter.convertEntityToDto(entity);
    }

    @Transactional(readOnly = true)
    public CarDto getDtoById(String id) {
        var entity = getEntityById(id);
        return CarDtoConverter.convertEntityToDto(entity);
    }

    @Transactional(readOnly = true)
    public CarEntity getEntityById(String id) {
        return carRepository.findById(id)
                .orElseThrow(() -> new exceptionNotFound("Машина с id " + id + " не найдена"));
    }


}
