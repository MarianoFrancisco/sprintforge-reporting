package com.sprintforge.reporting.reporting.application.mapper;

import com.sprintforge.reporting.reporting.application.port.in.event.employee.PaidEmployeeIntegrationEvent;
import com.sprintforge.reporting.reporting.domain.finance.FactEmployeePayment;
import lombok.experimental.UtilityClass;

@UtilityClass
public class FactEmployeePaymentMapper {
    public FactEmployeePayment from(
            PaidEmployeeIntegrationEvent event
    ) {
        return new FactEmployeePayment(
                event.paymentId(),
                event.employeeId(),
                event.date(),
                event.baseSalary(),
                event.bonus(),
                event.deduction(),
                event.total()
        );
    }
}
