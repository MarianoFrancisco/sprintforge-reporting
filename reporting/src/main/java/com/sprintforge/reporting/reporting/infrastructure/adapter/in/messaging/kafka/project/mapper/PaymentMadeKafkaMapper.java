package com.sprintforge.reporting.reporting.infrastructure.adapter.in.messaging.kafka.project.mapper;

import com.sprintforge.reporting.reporting.application.port.in.event.project.PaymentMadeIntegrationEvent;
import com.sprintforge.reporting.reporting.infrastructure.adapter.in.messaging.kafka.project.event.PaymentMadeKafkaMessage;
import lombok.experimental.UtilityClass;

@UtilityClass
public class PaymentMadeKafkaMapper {
    public PaymentMadeIntegrationEvent toEvent(
            PaymentMadeKafkaMessage message
    ) {
        return new PaymentMadeIntegrationEvent(
                message.paymentId(),
                message.projectId(),
                message.date(),
                message.amount(),
                message.method()
        );
    }
}
