package com.sprintforge.reporting.reporting.application.port.out.rest.scrum;

import java.util.UUID;

public record GetProjectProgressReportQuery(
        UUID projectId
) {
}
