package com.sprintforge.reporting.reporting.application.service.internal;

import java.time.LocalDate;
import java.util.List;

public record Income(
        LocalDate from,
        LocalDate to,
        IncomeSubtotal subtotalType,
        List<ProjectIncomeBlock> projects
) {
}
