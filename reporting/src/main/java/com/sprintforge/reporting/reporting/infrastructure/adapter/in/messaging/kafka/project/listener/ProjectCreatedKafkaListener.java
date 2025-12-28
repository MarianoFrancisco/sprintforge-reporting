package com.sprintforge.reporting.reporting.infrastructure.adapter.in.messaging.kafka.project.listener;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sprintforge.common.infrastructure.adapter.in.messaging.kafka.project.event.ProjectCreatedKafkaMessage;
import com.sprintforge.reporting.reporting.application.port.in.event.project.ProjectCreatedEventHandler;
import com.sprintforge.reporting.reporting.application.port.in.event.project.ProjectCreatedIntegrationEvent;
import com.sprintforge.reporting.reporting.infrastructure.adapter.in.messaging.kafka.project.mapper.ProjectCreatedKafkaMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class ProjectCreatedKafkaListener {

    private final ProjectCreatedEventHandler handler;
    private final ObjectMapper objectMapper;

    @KafkaListener(
            topics = "#{@kafkaTopicsProperties.projectCreated}",
            groupId = "#{@kafkaGroupsProperties.defaultGroup}"
    )
    public void listen(String payload) {
        try {
            log.debug("Received ProjectCreated raw payload: {}", payload);

            ProjectCreatedKafkaMessage message =
                    objectMapper.readValue(payload, ProjectCreatedKafkaMessage.class);

            log.debug("Parsed ProjectCreated event: {}", message);

            ProjectCreatedIntegrationEvent event = ProjectCreatedKafkaMapper.toEvent(message);
            handler.handle(event);

        } catch (JsonProcessingException ex) {
            log.warn("Skipping invalid ProjectCreated payload: {}", payload, ex);
        }
    }
}
