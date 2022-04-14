package com.example.backendkt.dto;

import com.opencsv.bean.CsvBindByPosition;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class CreateUpdateManufacturerDto {
    @NotBlank(message = "Название не указано")
    @CsvBindByPosition(position = 0)
    private String name;
}
