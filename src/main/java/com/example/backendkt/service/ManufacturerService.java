package com.example.backendkt.service;


import com.example.backendkt.dto.CreateUpdateManufacturerDto;
import com.example.backendkt.dto.ManufacturerDto;
import com.example.backendkt.dto.ManufacturerDtoWithoutCars;
import com.example.backendkt.dto.converter.ManufacturerConverterDto;
import com.example.backendkt.entity.CarEntity;
import com.example.backendkt.entity.ManufacturerEntity;
import com.example.backendkt.exception.exceptionNotFound;
import com.example.backendkt.repository.CarRepository;
import com.example.backendkt.repository.ManufacturerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ManufacturerService {

    private  final ManufacturerRepository manufacturerRepository;
    private  final CarRepository carRepository;

    @Transactional
    public ManufacturerDtoWithoutCars save(CreateUpdateManufacturerDto dto){
        ManufacturerEntity entity = ManufacturerConverterDto.convertDtoToEntity(dto);
        var savedEntity = manufacturerRepository.save(entity);
        return ManufacturerConverterDto.convertEntityToDtoWithoutCars(savedEntity);
    }

    @Transactional(readOnly = true)
    public ManufacturerDto getDtoById(String id){
       var entity = getEntityById(id);
        return  ManufacturerConverterDto.convertEntityToDtoWithCars(entity, getCarsByManufacturer(entity));
    }

    @Transactional(readOnly = true)
    public ManufacturerEntity getEntityById(String id) {
        return manufacturerRepository.findById(id)
                .orElseThrow(() -> new exceptionNotFound("Производитель с id " + id + " не найден"));
    }

    @Transactional(readOnly = true)
    public List<CarEntity> getCarsByManufacturer(ManufacturerEntity entity) {
        return carRepository.findByManufacturer(entity);
    }

}
