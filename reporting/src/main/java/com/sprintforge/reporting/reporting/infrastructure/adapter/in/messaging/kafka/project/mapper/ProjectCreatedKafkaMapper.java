package com.sprintforge.reporting.reporting.infrastructure.adapter.in.messaging.kafka.project.mapper;

import com.sprintforge.common.infrastructure.adapter.in.messaging.kafka.project.event.ProjectCreatedKafkaMessage;
import com.sprintforge.reporting.reporting.application.port.in.event.project.ProjectCreatedIntegrationEvent;
import lombok.experimental.UtilityClass;

@UtilityClass
public class ProjectCreatedKafkaMapper {
    public ProjectCreatedIntegrationEvent toEvent(
            ProjectCreatedKafkaMessage message
    ) {
        return new ProjectCreatedIntegrationEvent(
                message.projectId(),
                message.projectKey(),
                message.name(),
                message.client(),
                message.area(),
                message.isClosed(),
                message.isDeleted()
        );
    }
}
