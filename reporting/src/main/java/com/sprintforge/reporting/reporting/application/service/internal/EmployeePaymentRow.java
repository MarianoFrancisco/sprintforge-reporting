package com.sprintforge.reporting.reporting.application.port.result;

import java.math.BigDecimal;
import java.time.LocalDate;

public record EmployeePaymentRow(
        LocalDate date,
        BigDecimal baseSalary,
        BigDecimal bonus,
        BigDecimal deduction,
        BigDecimal total
) {
}
