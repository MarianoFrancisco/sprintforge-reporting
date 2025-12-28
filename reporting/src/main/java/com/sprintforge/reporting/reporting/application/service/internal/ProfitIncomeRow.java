package com.sprintforge.reporting.reporting.application.port.result;

import java.math.BigDecimal;
import java.time.LocalDate;

public record ProfitIncomeRow(
        LocalDate date,
        String projectKey,
        String projectName,
        String client,
        String area,
        String method,
        BigDecimal amount
) {
}
