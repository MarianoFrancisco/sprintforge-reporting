package com.sprintforge.reporting.reporting.application.port.result;

import java.math.BigDecimal;

public record PayrollExpenseSummary(
        BigDecimal baseSalary,
        BigDecimal bonus,
        BigDecimal deduction,
        BigDecimal total
) {
}
