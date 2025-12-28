package com.sprintforge.reporting.reporting.application.port.out.persistence;

import com.sprintforge.reporting.reporting.domain.employee.DimEmployee;

public interface SaveDimEmployee {
    void save(DimEmployee dimEmployee);
}
