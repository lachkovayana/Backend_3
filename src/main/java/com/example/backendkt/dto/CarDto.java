package com.example.backendkt.dto;

import lombok.Data;

@Data
public class CarDto {
    private String id;
    private String carModel;
    private int releaseYear;
    private String manufacturer;
}
