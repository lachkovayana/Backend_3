package com.example.backendkt.dto;

import com.opencsv.bean.CsvBindByPosition;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class CreateUpdateCarDto {
    @NotBlank(message = "Модель не указана")
    @CsvBindByPosition(position = 0)
    private String carModel;
    @NotNull(message = "Год выпуска не указан")
    @CsvBindByPosition(position = 1)
    private Integer releaseYear;
    @NotBlank(message = "Производитель не указан")
    @CsvBindByPosition(position = 2)
    private String manufacturer;
}
