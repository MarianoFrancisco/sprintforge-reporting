package com.sprintforge.reporting.reporting.application.port.out.persistence;

import com.sprintforge.reporting.reporting.domain.finance.FactEmployeePayment;

public interface SaveFactEmployeePayment {
    void save(FactEmployeePayment factEmployeePayment);
}
