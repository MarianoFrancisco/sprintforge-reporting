package com.sprintforge.reporting.reporting.infrastructure.adapter.in.messaging.kafka.project.event;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

public record PaidEmployeeKafkaMessage(
        UUID paymentId,
        UUID employeeId,
        LocalDate date,
        BigDecimal baseSalary,
        BigDecimal bonus,
        BigDecimal deduction,
        BigDecimal total
) {
}
