package com.sprintforge.reporting.reporting.application.port.in.event.project;

public interface ProjectCreatedEventHandler {
    void handle(ProjectCreatedIntegrationEvent event);
}
