package com.sprintforge.reporting.reporting.application.port.out.persistence;

import com.sprintforge.reporting.reporting.domain.finance.FactProjectPayment;

public interface SaveFactProjectPayment {
    void save(FactProjectPayment factProjectPayment);
}
