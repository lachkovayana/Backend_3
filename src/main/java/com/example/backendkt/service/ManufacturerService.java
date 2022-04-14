package com.example.backendkt.service;


import com.example.backendkt.dto.CreateUpdateManufacturerDto;
import com.example.backendkt.dto.ManufacturerDto;
import com.example.backendkt.dto.converter.ManufacturerConverterDto;
import com.example.backendkt.entity.ManufacturerEntity;
import com.example.backendkt.repository.ManufacturerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ManufacturerService {

    private  final ManufacturerRepository manufacturerRepository;

    @Transactional
    public ManufacturerDto save(CreateUpdateManufacturerDto dto){
        ManufacturerEntity entity = ManufacturerConverterDto.convertDtoToEntity(dto);
        var savedEntity = manufacturerRepository.save(entity);
        return ManufacturerConverterDto.convertEntityToDto(savedEntity);
    }
}
