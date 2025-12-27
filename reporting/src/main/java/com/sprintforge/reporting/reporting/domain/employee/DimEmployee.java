package com.sprintforge.reporting.reporting.domain.employee;

import com.sprintforge.reporting.reporting.domain.employee.valueobject.EmployeeStatus;
import lombok.Getter;

import java.util.UUID;

@Getter
public class DimEmployee {
    UUID employeeId;
    String fullName;
    EmployeeStatus status;

    public DimEmployee(
            UUID employeeId,
            String fullName,
            String status
    ) {
        this.employeeId = employeeId;
        this.fullName = fullName;
        this.status = EmployeeStatus.valueOf(status);
    }
}
