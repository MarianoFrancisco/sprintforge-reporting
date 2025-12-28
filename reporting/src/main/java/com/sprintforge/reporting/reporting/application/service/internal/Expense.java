package com.sprintforge.reporting.reporting.application.service.internal;

import java.time.LocalDate;
import java.util.List;

public record Expense(
        LocalDate from,
        LocalDate to,
        List<EmployeeExpenseDetail> employees,
        PayrollExpenseSummary summary
) {
}
