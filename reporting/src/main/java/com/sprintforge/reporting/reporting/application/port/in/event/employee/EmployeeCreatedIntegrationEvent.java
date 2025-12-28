package com.sprintforge.reporting.reporting.application.port.in.event.employee;

import java.util.UUID;

public record EmployeeCreatedIntegrationEvent(
        UUID employeeId,
        String fullName,
        String status
) {
}
