package com.sprintforge.reporting.reporting.application.port.out.persistence;

import com.sprintforge.reporting.reporting.application.port.result.ExpenseResult;

import java.time.LocalDate;

public interface LoadExpense {
    ExpenseResult loadExpense(LocalDate from, LocalDate to);
}
