package com.example.backendkt.repository;

import com.example.backendkt.entity.CarEntity;
import com.example.backendkt.entity.ManufacturerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarRepository extends JpaRepository<CarEntity, String> {
    List<CarEntity> findByManufacturer(ManufacturerEntity entity);
}
