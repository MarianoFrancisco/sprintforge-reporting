package com.sprintforge.reporting.reporting.application.port.out.persistence;

import com.sprintforge.reporting.reporting.application.service.internal.Expense;

import java.time.LocalDate;

public interface LoadExpense {
    Expense loadExpense(LocalDate from, LocalDate to);
}
