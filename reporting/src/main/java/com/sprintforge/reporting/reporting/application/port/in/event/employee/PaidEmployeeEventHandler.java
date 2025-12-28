package com.sprintforge.reporting.reporting.application.port.in.event.employee;

public interface PaidEmployeeEventHandler {
    void handle(PaidEmployeeIntegrationEvent event);
}
