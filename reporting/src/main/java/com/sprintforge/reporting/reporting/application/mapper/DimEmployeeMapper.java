package com.sprintforge.reporting.reporting.application.mapper;

import com.sprintforge.reporting.reporting.application.port.in.event.employee.EmployeeCreatedIntegrationEvent;
import com.sprintforge.reporting.reporting.domain.employee.DimEmployee;
import lombok.experimental.UtilityClass;

@UtilityClass
public class DimEmployeeMapper {
    public DimEmployee toDomain(
            EmployeeCreatedIntegrationEvent event
    ) {
        return new DimEmployee(
                event.employeeId(),
                event.fullName(),
                event.status()
        );
    }
}
