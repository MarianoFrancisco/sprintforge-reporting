package com.sprintforge.reporting.reporting.application.service.internal;

import java.math.BigDecimal;

public record PayrollExpenseSummary(
        BigDecimal baseSalary,
        BigDecimal bonus,
        BigDecimal deduction,
        BigDecimal total
) {
}
