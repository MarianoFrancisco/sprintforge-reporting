package com.sprintforge.reporting.reporting.application.port.result;

import java.math.BigDecimal;
import java.util.UUID;

public record ProjectTotalRow(
        UUID projectId,
        String projectKey,
        String projectName,
        BigDecimal total
) {
}
