package com.sprintforge.reporting.reporting.application.port.out.persistence;

import com.sprintforge.reporting.reporting.application.port.result.ProfitResult;

import java.time.LocalDate;

public interface LoadProfit {
    ProfitResult loadProfit(LocalDate from, LocalDate to);
}
