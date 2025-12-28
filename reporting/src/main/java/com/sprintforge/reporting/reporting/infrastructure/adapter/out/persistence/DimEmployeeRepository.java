package com.sprintforge.reporting.reporting.infrastructure.adapter.out.persistence;

import com.sprintforge.reporting.reporting.application.port.out.persistence.SaveDimEmployee;
import com.sprintforge.reporting.reporting.domain.employee.DimEmployee;
import com.sprintforge.reporting.reporting.infrastructure.adapter.out.persistence.entity.DimEmployeeEntity;
import com.sprintforge.reporting.reporting.infrastructure.adapter.out.persistence.mapper.DimEmployeeEntityMapper;
import com.sprintforge.reporting.reporting.infrastructure.adapter.out.persistence.repository.DimEmployeeJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class DimEmployeeRepository implements
        SaveDimEmployee {

    private final DimEmployeeJpaRepository dimEmployeeJpaRepository;

    @Override
    public void save(DimEmployee dimEmployee) {
        DimEmployeeEntity entity = DimEmployeeEntityMapper.toEntity(dimEmployee);
        dimEmployeeJpaRepository.save(entity);
    }
}
