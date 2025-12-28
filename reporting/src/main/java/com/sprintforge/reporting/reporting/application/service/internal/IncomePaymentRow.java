package com.sprintforge.reporting.reporting.application.service.internal;

import java.math.BigDecimal;
import java.time.LocalDate;

public record IncomePaymentRow(
        LocalDate date,
        String method,
        BigDecimal amount
) {
}
