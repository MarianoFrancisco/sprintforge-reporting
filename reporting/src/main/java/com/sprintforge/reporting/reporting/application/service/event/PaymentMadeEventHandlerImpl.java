package com.sprintforge.reporting.reporting.application.service.event;

import com.sprintforge.reporting.reporting.application.mapper.FactProjectPaymentMapper;
import com.sprintforge.reporting.reporting.application.port.in.event.project.PaymentMadeEventHandler;
import com.sprintforge.reporting.reporting.application.port.in.event.project.PaymentMadeIntegrationEvent;
import com.sprintforge.reporting.reporting.application.port.out.persistence.SaveFactProjectPayment;
import com.sprintforge.reporting.reporting.domain.finance.FactProjectPayment;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(rollbackFor = Exception.class)
public class PaymentMadeEventHandlerImpl implements PaymentMadeEventHandler {

    private final SaveFactProjectPayment saveFactProjectPayment;

    @Override
    public void handle(PaymentMadeIntegrationEvent event) {
        FactProjectPayment factProjectPayment = FactProjectPaymentMapper.from(event);
        saveFactProjectPayment.save(factProjectPayment);
    }
}
