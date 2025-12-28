package com.sprintforge.reporting.reporting.infrastructure.adapter.out.persistence.projection;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

public interface ProjectPaymentDetailView {
    UUID getProjectId();

    LocalDate getDate();

    String getMethod();

    BigDecimal getAmount();
}
