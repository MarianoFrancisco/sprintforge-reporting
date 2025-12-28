package com.sprintforge.reporting.reporting.infrastructure.adapter.out.persistence.repository;

import com.sprintforge.reporting.reporting.infrastructure.adapter.out.persistence.entity.DimEmployeeEntity;
import org.jspecify.annotations.NullMarked;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

@NullMarked
public interface DimEmployeeJpaRepository extends
        JpaRepository<DimEmployeeEntity, UUID> {
}
