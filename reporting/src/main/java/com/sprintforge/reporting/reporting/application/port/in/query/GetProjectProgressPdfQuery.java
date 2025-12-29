package com.sprintforge.reporting.reporting.application.port.in.query;

import java.util.UUID;

public record GetProjectProgressPdfQuery(
        UUID projectId
) {
}
