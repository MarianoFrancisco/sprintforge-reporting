package com.sprintforge.reporting.common.infrastructure.config.kafka;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class KafkaTopicsProperties {
    private String employeeCreated;
    private String projectCreated;
    private String paymentMade;
    private String paidEmployee;
}
