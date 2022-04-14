package com.example.backendkt.dto;

import com.opencsv.bean.CsvBindByPosition;
import lombok.Data;

@Data
public class CreateUpdateManufacturerDto {
    @CsvBindByPosition(position = 0)
    private String name;
}
