package com.sprintforge.reporting.reporting.application.port.result;

import java.time.LocalDate;
import java.util.List;

public record IncomeResult(
        LocalDate from,
        LocalDate to,
        IncomeSubtotal subtotalType,
        List<ProjectIncomeBlock> projects
) {
}
