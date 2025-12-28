package com.sprintforge.reporting.reporting.application.service.event;

import com.sprintforge.reporting.reporting.application.mapper.FactEmployeePaymentMapper;
import com.sprintforge.reporting.reporting.application.port.in.event.employee.PaidEmployeeEventHandler;
import com.sprintforge.reporting.reporting.application.port.in.event.employee.PaidEmployeeIntegrationEvent;
import com.sprintforge.reporting.reporting.application.port.out.persistence.SaveFactEmployeePayment;
import com.sprintforge.reporting.reporting.domain.finance.FactEmployeePayment;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(rollbackFor = Exception.class)
public class PaidEmployeeEventHandlerImpl implements PaidEmployeeEventHandler {

    private final SaveFactEmployeePayment saveFactEmployeePayment;

    @Override
    public void handle(PaidEmployeeIntegrationEvent event) {
        FactEmployeePayment factEmployeePayment = FactEmployeePaymentMapper.from(event);
        saveFactEmployeePayment.save(factEmployeePayment);
    }
}
