package com.example.backendkt.dto;

import lombok.Data;

@Data
public class CarDtoWithoutManufacturer {
    private String id;
    private String carModel;
    private Integer releaseYear;
}
