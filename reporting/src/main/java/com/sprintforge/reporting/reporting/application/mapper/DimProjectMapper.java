package com.sprintforge.reporting.reporting.application.mapper;

import com.sprintforge.reporting.reporting.application.port.in.event.project.ProjectCreatedIntegrationEvent;
import com.sprintforge.reporting.reporting.domain.project.DimProject;
import lombok.experimental.UtilityClass;

@UtilityClass
public class DimProjectMapper {
    public DimProject toDomain(
            ProjectCreatedIntegrationEvent event
    ) {
        return new DimProject(
                event.projectId(),
                event.projectKey(),
                event.name(),
                event.client(),
                event.area(),
                event.isClosed(),
                event.isDeleted()
        );
    }
}
