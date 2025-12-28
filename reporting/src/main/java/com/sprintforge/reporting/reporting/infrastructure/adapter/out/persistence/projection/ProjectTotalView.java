package com.sprintforge.reporting.reporting.infrastructure.adapter.out.persistence.projection;

import java.math.BigDecimal;
import java.util.UUID;

public interface ProjectTotalView {
    UUID getProjectId();

    String getProjectKey();

    String getProjectName();

    String getClient();

    String getArea();

    BigDecimal getTotal();
}
