package com.example.backendkt.dto;

import lombok.Data;

import java.util.Map;

@Data
public class FetchCarDto {
    private Map<String, String> filters;

}
