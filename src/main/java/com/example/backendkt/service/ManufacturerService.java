package com.example.backendkt.service;


import com.example.backendkt.dto.CreateUpdateManufacturerDto;
import com.example.backendkt.dto.ManufacturerDto;
import com.example.backendkt.dto.ManufacturerDtoWithoutCars;
import com.example.backendkt.dto.converter.ManufacturerConverterDto;
import com.example.backendkt.entity.CarEntity;
import com.example.backendkt.entity.ManufacturerEntity;
import com.example.backendkt.exception.exceptionNotFound;
import com.example.backendkt.exception.exceptionNotUnique;
import com.example.backendkt.repository.CarRepository;
import com.example.backendkt.repository.ManufacturerRepository;
import com.opencsv.bean.CsvToBeanBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class ManufacturerService {

    private final ManufacturerRepository manufacturerRepository;
    private final CarRepository carRepository;

    @Transactional
    public ManufacturerDtoWithoutCars save(CreateUpdateManufacturerDto dto) {
        if (!(manufacturerRepository.findByName(dto.getName()).size() == 0)) {
            throw new exceptionNotUnique("Название " + dto.getName() + " уже используется");
        }

        ManufacturerEntity entity = ManufacturerConverterDto.convertDtoToEntity(dto);
        var savedEntity = manufacturerRepository.save(entity);
        return ManufacturerConverterDto.convertEntityToDtoWithoutCars(savedEntity);
    }

    @Transactional
    public void initCsv() {
        manufacturerRepository.deleteAll();
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("manufacturers.csv");
        var manufacturers = new CsvToBeanBuilder<CreateUpdateManufacturerDto>(new InputStreamReader(Objects.requireNonNull(inputStream)))
                .withSeparator(',')
                .withType(CreateUpdateManufacturerDto.class)
                .withSkipLines(1)
                .build()
                .parse();

        manufacturers.forEach(elem->{
            ManufacturerEntity entity = ManufacturerConverterDto.convertDtoToEntity(elem);
            manufacturerRepository.save(entity);
        });
    }

    @Transactional(readOnly = true)
    public ManufacturerDto getDtoById(String id) {
        var entity = getEntityById(id);
        return ManufacturerConverterDto.convertEntityToDtoWithCars(entity, getCarsByManufacturer(entity));
    }

    @Transactional(readOnly = true)
    public ManufacturerEntity getEntityById(String id) {
        return manufacturerRepository.findById(id)
                .orElseThrow(() -> new exceptionNotFound("Производитель с id " + id + " не найден"));
    }

    @Transactional(readOnly = true)
    public ManufacturerEntity getEntityByName(String name) {
        return manufacturerRepository.findByName(name).stream().findFirst()
                .orElseThrow(() -> new exceptionNotFound("Производитель с названием " + name + " не найден"));
    }

    @Transactional(readOnly = true)
    public List<CarEntity> getCarsByManufacturer(ManufacturerEntity entity) {
        // ???
//        carRepository.findByManufacturer(entity).stream().findFirst()
//                .orElseThrow(() -> new exceptionNotFound("Производитель с id " + entity.getId() + " не найден"));

        return carRepository.findByManufacturer(entity);
    }

}
