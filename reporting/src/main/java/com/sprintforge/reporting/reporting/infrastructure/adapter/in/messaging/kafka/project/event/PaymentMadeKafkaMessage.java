package com.sprintforge.reporting.reporting.infrastructure.adapter.in.messaging.kafka.project.event;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

public record PaymentMadeKafkaMessage(
        UUID paymentId,
        UUID projectId,
        LocalDate date,
        BigDecimal amount,
        String method
) {
}
