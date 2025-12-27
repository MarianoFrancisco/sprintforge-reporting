package com.sprintforge.reporting.reporting.domain.finance;

import com.sprintforge.reporting.reporting.domain.finance.valueobject.PaymentMethod;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Getter
public class FactProjectPayment {
    UUID paymentId;
    UUID projectId;
    LocalDate date;
    BigDecimal amount;
    PaymentMethod method;

    public FactProjectPayment(
            UUID paymentId,
            UUID projectId,
            LocalDate date,
            BigDecimal amount,
            String method
    ) {
        this.paymentId = paymentId;
        this.projectId = projectId;
        this.date = date;
        this.amount = amount;
        this.method = PaymentMethod.from(method);
    }
}
