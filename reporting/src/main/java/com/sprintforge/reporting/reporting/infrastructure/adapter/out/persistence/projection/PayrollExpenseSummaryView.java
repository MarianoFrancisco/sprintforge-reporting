package com.sprintforge.reporting.reporting.infrastructure.adapter.out.persistence.projection;

import java.math.BigDecimal;

public interface PayrollExpenseSummaryView {
    BigDecimal getBaseSalary();

    BigDecimal getBonus();

    BigDecimal getDeduction();

    BigDecimal getTotal();
}
