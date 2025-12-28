package com.sprintforge.reporting.reporting.infrastructure.adapter.in.messaging.kafka.project.listener;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sprintforge.reporting.reporting.application.port.in.event.project.PaymentMadeEventHandler;
import com.sprintforge.reporting.reporting.application.port.in.event.project.PaymentMadeIntegrationEvent;
import com.sprintforge.reporting.reporting.infrastructure.adapter.in.messaging.kafka.project.event.PaymentMadeKafkaMessage;
import com.sprintforge.reporting.reporting.infrastructure.adapter.in.messaging.kafka.project.mapper.PaymentMadeKafkaMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class PaymentMadeKafkaListener {

    private final PaymentMadeEventHandler handler;
    private final ObjectMapper objectMapper;

    @KafkaListener(
            topics = "#{@kafkaTopicsProperties.PaymentMade}",
            groupId = "#{@kafkaGroupsProperties.defaultGroup}"
    )
    public void listen(String payload) {
        try {
            log.debug("Received PaymentMade raw payload: {}", payload);

            PaymentMadeKafkaMessage message =
                    objectMapper.readValue(payload, PaymentMadeKafkaMessage.class);

            log.debug("Parsed PaymentMade event: {}", message);

            PaymentMadeIntegrationEvent event = PaymentMadeKafkaMapper.toEvent(message);
            handler.handle(event);

        } catch (JsonProcessingException ex) {
            log.warn("Skipping invalid PaymentMade payload: {}", payload, ex);
        }
    }
}
