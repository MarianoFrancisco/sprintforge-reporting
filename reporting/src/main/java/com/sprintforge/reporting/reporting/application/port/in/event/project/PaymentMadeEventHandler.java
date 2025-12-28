package com.sprintforge.reporting.reporting.application.port.in.event.project;

public interface PaymentMadeEventHandler {
    void handle(PaymentMadeIntegrationEvent event);
}
