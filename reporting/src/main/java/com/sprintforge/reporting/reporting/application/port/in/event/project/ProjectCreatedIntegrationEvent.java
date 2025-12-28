package com.sprintforge.reporting.reporting.application.port.in.event.project;

import java.util.UUID;

public record ProjectCreatedIntegrationEvent(
        UUID projectId,
        String projectKey,
        String name,
        String client,
        String area,
        boolean isClosed,
        boolean isDeleted
) {
}
