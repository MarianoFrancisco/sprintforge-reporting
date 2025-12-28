package com.sprintforge.reporting.reporting.application.port.result;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

public record ProfitExpenseRow(
        LocalDate date,
        UUID employeeId,
        String fullName,
        BigDecimal baseSalary,
        BigDecimal bonus,
        BigDecimal deduction,
        BigDecimal total
) {
}
