package com.sprintforge.reporting.reporting.application.port.in.event.employee;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

public record PaidEmployeeIntegrationEvent(
        UUID paymentId,
        UUID employeeId,
        LocalDate date,
        BigDecimal baseSalary,
        BigDecimal bonus,
        BigDecimal deduction,
        BigDecimal total
) {
}
