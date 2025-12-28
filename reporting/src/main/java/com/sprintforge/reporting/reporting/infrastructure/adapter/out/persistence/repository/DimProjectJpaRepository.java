package com.sprintforge.reporting.reporting.infrastructure.adapter.out.persistence.repository;

import com.sprintforge.reporting.reporting.infrastructure.adapter.out.persistence.entity.DimProjectEntity;
import org.jspecify.annotations.NullMarked;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

@NullMarked
public interface DimProjectJpaRepository extends
        JpaRepository<DimProjectEntity, UUID> {
}
