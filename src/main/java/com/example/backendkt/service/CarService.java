package com.example.backendkt.service;

import com.example.backendkt.dto.CarDto;
import com.example.backendkt.dto.CreateUpdateCarDto;
import com.example.backendkt.dto.converter.CarDtoConverter;
import com.example.backendkt.entity.CarEntity;
import com.example.backendkt.repository.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class CarService {
    private final CarRepository carRepository;

    @Transactional
    public CarDto createTask(CreateUpdateCarDto dto) {

        CarEntity entity = CarDtoConverter.convertDtoToEntity(dto);
        entity = carRepository.save(entity);
        return CarDtoConverter.convertEntityToDto(entity);
    }

}
