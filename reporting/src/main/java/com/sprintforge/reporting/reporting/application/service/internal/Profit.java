package com.sprintforge.reporting.reporting.application.port.result;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public record ProfitResult(
        LocalDate from,
        LocalDate to,
        List<ProfitIncomeRow> incomes,
        BigDecimal totalIncome,
        List<ProfitExpenseRow> expenses,
        BigDecimal totalExpense,
        BigDecimal profit
) {
}
