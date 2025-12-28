package com.sprintforge.reporting.reporting.application.port.in.query;

import com.sprintforge.reporting.reporting.application.port.result.IncomeSubtotal;

import java.time.LocalDate;
import java.util.UUID;

public record GetIncomePdfQuery(
        LocalDate from,
        LocalDate to,
        IncomeSubtotal subtotalType,
        UUID projectId
) {
}
