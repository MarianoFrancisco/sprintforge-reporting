package com.sprintforge.reporting.reporting.infrastructure.adapter.out.persistence.mapper;

import com.sprintforge.reporting.reporting.domain.project.DimProject;
import com.sprintforge.reporting.reporting.infrastructure.adapter.out.persistence.entity.DimProjectEntity;
import lombok.experimental.UtilityClass;

@UtilityClass
public class DimProjectEntityMapper {
    public DimProjectEntity toEntity(DimProject domain) {
        if (domain == null) {
            return null;
        }

        return DimProjectEntity.builder()
                .projectId(domain.getProjectId())
                .projectKey(domain.getProjectKey())
                .name(domain.getName())
                .client(domain.getClient())
                .area(domain.getArea())
                .isClosed(domain.isClosed())
                .isDeleted(domain.isDeleted())
                .build();
    }
}
