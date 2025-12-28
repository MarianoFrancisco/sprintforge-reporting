package com.sprintforge.reporting.reporting.infrastructure.adapter.out.persistence.projection;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

public interface ProfitExpenseView {
    LocalDate getDate();

    UUID getEmployeeId();

    String getFullName();

    BigDecimal getBaseSalary();

    BigDecimal getBonus();

    BigDecimal getDeduction();

    BigDecimal getTotal();
}
