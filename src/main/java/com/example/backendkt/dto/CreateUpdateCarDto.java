package com.example.backendkt.dto;

import lombok.Data;

@Data
public class CreateUpdateCarDto {
    private String carModel;
    private int releaseYear;
    private String manufacturerId;
}
