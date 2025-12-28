package com.sprintforge.reporting.reporting.application.port.result;

import java.time.LocalDate;
import java.util.List;

public record ExpenseResult(
        LocalDate from,
        LocalDate to,
        List<EmployeeExpenseDetail> employees,
        PayrollExpenseSummary summary
) {
}
