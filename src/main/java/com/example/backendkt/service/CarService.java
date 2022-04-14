package com.example.backendkt.service;

import com.example.backendkt.dto.CarDto;
import com.example.backendkt.dto.CreateUpdateCarDto;
import com.example.backendkt.dto.FetchCarDto;
import com.example.backendkt.dto.converter.CarDtoConverter;
import com.example.backendkt.entity.CarEntity;
import com.example.backendkt.entity.ManufacturerEntity;
import com.example.backendkt.exception.exceptionNotFound;
import com.example.backendkt.repository.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.Predicate;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

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


    @Transactional(readOnly = true)
    public List<CarDto> fetchCars(FetchCarDto dto) {
        return carRepository.findAll(((root, query, criteriaBuilder) -> {
                    var predicates = new ArrayList<>();
                    dto.getFilters().forEach((fieldName, fieldValue) -> {
                        switch (fieldName) {
                            case "carModel":
                                predicates.add(criteriaBuilder.like(root.get(fieldName), '%' + fieldValue + '%'));
                                break;
                            case "releaseYear":
                                predicates.add(criteriaBuilder.equal(root.get(fieldName), fieldValue));
                                break;
                            case "manufacturer":
                                predicates.add(criteriaBuilder.equal(root.get(fieldName).get("id"), fieldValue));
                                break;
                            default:
                                throw new RuntimeException("Несуществуещее поле поиска: " + fieldName);
                        }
                    });

                    return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
                }))
                .stream()
                .map(CarDtoConverter::convertEntityToDto)
                .collect(Collectors.toList());
    }
}
