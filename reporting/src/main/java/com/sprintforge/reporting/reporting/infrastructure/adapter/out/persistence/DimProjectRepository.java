package com.sprintforge.reporting.reporting.infrastructure.adapter.out.persistence;

import com.sprintforge.reporting.reporting.application.port.out.persistence.SaveDimProject;
import com.sprintforge.reporting.reporting.domain.project.DimProject;
import com.sprintforge.reporting.reporting.infrastructure.adapter.out.persistence.entity.DimProjectEntity;
import com.sprintforge.reporting.reporting.infrastructure.adapter.out.persistence.mapper.DimProjectEntityMapper;
import com.sprintforge.reporting.reporting.infrastructure.adapter.out.persistence.repository.DimProjectJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class DimProjectRepository implements
        SaveDimProject {

    private final DimProjectJpaRepository dimProjectJpaRepository;

    @Override
    public void save(DimProject dimProject) {
        DimProjectEntity entity = DimProjectEntityMapper.toEntity(dimProject);
        dimProjectJpaRepository.save(entity);
    }
}
