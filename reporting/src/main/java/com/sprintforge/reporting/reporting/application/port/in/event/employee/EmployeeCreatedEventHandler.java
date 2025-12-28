package com.sprintforge.reporting.reporting.application.port.in.event.employee;

public interface EmployeeCreatedEventHandler {
    void handle(EmployeeCreatedIntegrationEvent event);
}
