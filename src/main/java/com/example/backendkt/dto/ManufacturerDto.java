package com.example.backendkt.dto;

import lombok.Data;

import java.util.List;

@Data
public class ManufacturerDto {
    private String id;
    private String name;
    private List<CarDto> cars;
}
