package com.sprintforge.reporting.reporting.infrastructure.adapter.in.messaging.kafka.project.mapper;

import com.sprintforge.reporting.reporting.application.port.in.event.employee.PaidEmployeeIntegrationEvent;
import com.sprintforge.reporting.reporting.infrastructure.adapter.in.messaging.kafka.project.event.PaidEmployeeKafkaMessage;
import lombok.experimental.UtilityClass;

@UtilityClass
public class PaidEmployeeKafkaMapper {
    public PaidEmployeeIntegrationEvent toEvent(
            PaidEmployeeKafkaMessage message
    ) {
        return new PaidEmployeeIntegrationEvent(
                message.paymentId(),
                message.employeeId(),
                message.date(),
                message.baseSalary(),
                message.bonus(),
                message.deduction(),
                message.total()
        );
    }
}
