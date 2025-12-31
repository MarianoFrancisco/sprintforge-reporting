package com.sprintforge.reporting.reporting.infrastructure.adapter.out.rest.scrum.mapper;

import com.sprintforge.common.application.port.result.EmployeeProductivityItem;
import com.sprintforge.common.application.port.result.EmployeeProductivityReportResult;
import com.sprintforge.common.application.port.result.EmployeeResult;
import com.sprintforge.common.infrastructure.adapter.in.rest.dto.EmployeeDTO;
import com.sprintforge.common.infrastructure.adapter.in.rest.dto.EmployeeProductivityItemDTO;
import com.sprintforge.common.infrastructure.adapter.in.rest.dto.EmployeeProductivityReportResponseDTO;
import lombok.experimental.UtilityClass;

import java.util.List;

@UtilityClass
public class EmployeeProductivityReportResultMapper {

    public EmployeeProductivityReportResult toResult(
            EmployeeProductivityReportResponseDTO response
    ) {
        return new EmployeeProductivityReportResult(
                response.from(),
                response.to(),
                mapEmployees(response.employees()),
                response.totalEmployees()
        );
    }

    private static List<EmployeeProductivityItem> mapEmployees(
            List<EmployeeProductivityItemDTO> employees
    ) {
        return employees.stream()
                .map(EmployeeProductivityReportResultMapper::mapEmployee)
                .toList();
    }

    private static EmployeeProductivityItem mapEmployee(
            EmployeeProductivityItemDTO e
    ) {
        return new EmployeeProductivityItem(
                mapEmployeeResult(e.employee()),
                e.workedStories(),
                e.completedStories(),
                e.pendingStories(),
                e.deliveredStoryPoints(),
                e.hoursWorked()
        );
    }

    private static EmployeeResult mapEmployeeResult(
            EmployeeDTO e
    ) {
        return new EmployeeResult(
                e.id(),
                e.email(),
                e.fullName(),
                e.profileImage(),
                e.position()
        );
    }
}
