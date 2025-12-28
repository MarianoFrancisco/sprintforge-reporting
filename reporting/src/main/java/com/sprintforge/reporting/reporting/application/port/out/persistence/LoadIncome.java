package com.sprintforge.reporting.reporting.application.port.out.persistence;

import com.sprintforge.reporting.reporting.application.port.result.IncomeResult;
import com.sprintforge.reporting.reporting.application.port.result.IncomeSubtotal;

import java.time.LocalDate;
import java.util.UUID;

public interface LoadIncome {
    IncomeResult loadIncome(
            LocalDate from,
            LocalDate to,
            IncomeSubtotal subtotalType,
            UUID projectId
    );
}
