package com.sprintforge.reporting.reporting.infrastructure.adapter.in.messaging.kafka.project.listener;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sprintforge.reporting.reporting.application.port.in.event.employee.PaidEmployeeEventHandler;
import com.sprintforge.reporting.reporting.application.port.in.event.employee.PaidEmployeeIntegrationEvent;
import com.sprintforge.reporting.reporting.infrastructure.adapter.in.messaging.kafka.project.event.PaidEmployeeKafkaMessage;
import com.sprintforge.reporting.reporting.infrastructure.adapter.in.messaging.kafka.project.mapper.PaidEmployeeKafkaMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class PaidEmployeeKafkaListener {

    private final PaidEmployeeEventHandler handler;
    private final ObjectMapper objectMapper;

    @KafkaListener(
            topics = "#{@kafkaTopicsProperties.paidEmployee}",
            groupId = "#{@kafkaGroupsProperties.defaultGroup}"
    )
    public void listen(String payload) {
        try {
            log.debug("Received PaidEmployee raw payload: {}", payload);

            PaidEmployeeKafkaMessage message =
                    objectMapper.readValue(payload, PaidEmployeeKafkaMessage.class);

            log.debug("Parsed PaidEmployee event: {}", message);

            PaidEmployeeIntegrationEvent event = PaidEmployeeKafkaMapper.toEvent(message);
            handler.handle(event);

        } catch (JsonProcessingException ex) {
            log.warn("Skipping invalid PaidEmployee payload: {}", payload, ex);
        }
    }
}
