package com.sprintforge.reporting.reporting.application.port.out.persistence;

import com.sprintforge.reporting.reporting.application.service.internal.Profit;

import java.time.LocalDate;

public interface LoadProfit {
    Profit loadProfit(LocalDate from, LocalDate to);
}
