package com.example.backendkt.dto;

import com.opencsv.bean.CsvBindByPosition;
import lombok.Data;

@Data
public class CreateUpdateCarDto {
    @CsvBindByPosition(position = 0)
    private String carModel;
    @CsvBindByPosition(position = 1)
    private int releaseYear;
    @CsvBindByPosition(position = 2)
    private String manufacturer;
}
