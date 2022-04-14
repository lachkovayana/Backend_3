package com.example.backendkt.dto;

import lombok.Data;

@Data
public class CarDto {
    private String id;
    private String model;
    private  int year;
    private String manufacturerId;
}
