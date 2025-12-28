package com.sprintforge.reporting.reporting.infrastructure.adapter.in.messaging.kafka.employee.mapper;

import com.sprintforge.common.infrastructure.adapter.in.messaging.kafka.employee.event.EmployeeCreatedKafkaMessage;
import com.sprintforge.reporting.reporting.application.port.in.event.employee.EmployeeCreatedIntegrationEvent;
import lombok.experimental.UtilityClass;

@UtilityClass
public class EmployeeCreatedKafkaMapper {
    public EmployeeCreatedIntegrationEvent toEvent(
            EmployeeCreatedKafkaMessage message
    ) {
        return new EmployeeCreatedIntegrationEvent(
                message.employeeId(),
                message.fullName(),
                message.status()
        );
    }
}
