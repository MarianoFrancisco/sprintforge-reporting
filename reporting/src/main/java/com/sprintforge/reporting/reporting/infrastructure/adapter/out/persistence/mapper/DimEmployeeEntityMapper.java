package com.sprintforge.reporting.reporting.infrastructure.adapter.out.persistence.mapper;

import com.sprintforge.reporting.reporting.domain.employee.DimEmployee;
import com.sprintforge.reporting.reporting.infrastructure.adapter.out.persistence.entity.DimEmployeeEntity;
import lombok.experimental.UtilityClass;

@UtilityClass
public class DimEmployeeEntityMapper {
    public DimEmployeeEntity toEntity(DimEmployee domain) {
        if (domain == null) {
            return null;
        }

        return DimEmployeeEntity.builder()
                .employeeId(domain.getEmployeeId())
                .fullName(domain.getFullName())
                .status(domain.getStatus().name())
                .build();
    }
}
