package com.sprintforge.reporting.reporting.application.port.out.persistence;

import com.sprintforge.reporting.reporting.application.service.internal.Income;
import com.sprintforge.reporting.reporting.application.service.internal.IncomeSubtotal;

import java.time.LocalDate;
import java.util.UUID;

public interface LoadIncome {
    Income loadIncome(
            LocalDate from,
            LocalDate to,
            IncomeSubtotal subtotalType,
            UUID projectId
    );
}
