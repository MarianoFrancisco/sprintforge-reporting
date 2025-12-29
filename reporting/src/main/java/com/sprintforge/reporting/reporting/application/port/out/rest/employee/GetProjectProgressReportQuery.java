package com.sprintforge.reporting.reporting.application.port.out.rest.employee;

import java.util.UUID;

public record GetProjectProgressReportQuery(
        UUID projectId
) {
}
