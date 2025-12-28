package com.sprintforge.reporting.reporting.infrastructure.adapter.out.persistence.projection;

import java.math.BigDecimal;
import java.time.LocalDate;

public interface ProfitIncomeView {
    LocalDate getDate();

    String getProjectKey();

    String getProjectName();

    String getClient();

    String getArea();

    String getMethod();

    BigDecimal getAmount();
}
