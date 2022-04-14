package com.example.backendkt.repository;

import com.example.backendkt.entity.CarEntity;
import com.example.backendkt.entity.ManufacturerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ManufacturerRepository extends JpaRepository<ManufacturerEntity, String> {
    List<ManufacturerEntity> findByName(String name);
}
