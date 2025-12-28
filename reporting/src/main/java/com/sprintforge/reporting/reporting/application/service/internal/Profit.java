package com.sprintforge.reporting.reporting.application.service.internal;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public record Profit(
        LocalDate from,
        LocalDate to,
        List<ProfitIncomeRow> incomes,
        BigDecimal totalIncome,
        List<ProfitExpenseRow> expenses,
        BigDecimal totalExpense,
        BigDecimal profit
) {
}
