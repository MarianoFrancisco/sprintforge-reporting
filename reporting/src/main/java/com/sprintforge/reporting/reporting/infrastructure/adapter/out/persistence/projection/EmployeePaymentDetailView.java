package com.sprintforge.reporting.reporting.infrastructure.adapter.out.persistence.projection;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

public interface EmployeePaymentDetailView {
    UUID getEmployeeId();

    String getFullName();

    LocalDate getDate();

    BigDecimal getBaseSalary();

    BigDecimal getBonus();

    BigDecimal getDeduction();

    BigDecimal getTotal();
}
