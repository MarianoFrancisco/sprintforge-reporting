package com.sprintforge.reporting.reporting.application.mapper;

import com.sprintforge.reporting.reporting.application.port.in.event.project.PaymentMadeIntegrationEvent;
import com.sprintforge.reporting.reporting.domain.finance.FactProjectPayment;
import lombok.experimental.UtilityClass;

@UtilityClass
public class FactProjectPaymentMapper {
    public FactProjectPayment from(
            PaymentMadeIntegrationEvent event
    ) {
        return new FactProjectPayment(
                event.paymentId(),
                event.projectId(),
                event.date(),
                event.amount(),
                event.method()
        );
    }
}
