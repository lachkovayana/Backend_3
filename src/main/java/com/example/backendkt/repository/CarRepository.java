package com.example.backendkt.repository;

import com.example.backendkt.entity.CarEntity;
import com.example.backendkt.entity.ManufacturerEntity;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface CarRepository extends JpaRepository<CarEntity, String>, JpaSpecificationExecutor<CarEntity> {
    @Override
    List<CarEntity> findAll(Specification<CarEntity> spec);

    List<CarEntity> findByManufacturer(ManufacturerEntity entity);
}
