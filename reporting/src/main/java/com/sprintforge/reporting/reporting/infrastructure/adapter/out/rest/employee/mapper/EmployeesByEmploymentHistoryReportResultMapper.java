package com.sprintforge.reporting.reporting.infrastructure.adapter.out.rest.employee.mapper;

import com.sprintforge.common.application.port.result.*;
import com.sprintforge.common.infrastructure.adapter.in.rest.dto.*;

import lombok.experimental.UtilityClass;

import java.util.List;

@UtilityClass
public class EmployeesByEmploymentHistoryReportResultMapper {

    public EmployeesByEmploymentHistoryReportResult toResult(
            EmployeesByEmploymentHistoryReportResponseDTO response
    ) {
        return new EmployeesByEmploymentHistoryReportResult(
                response.from(),
                response.to(),
                response.total(),
                mapEmployees(response.employees())
        );
    }

    private static List<EmployeeRow> mapEmployees(
            List<EmployeeRowDTO> employees
    ) {
        return safe(employees).stream()
                .map(EmployeesByEmploymentHistoryReportResultMapper::mapEmployee)
                .toList();
    }

    private static EmployeeRow mapEmployee(
            EmployeeRowDTO employee
    ) {
        return new EmployeeRow(
                employee.employeeId(),
                employee.cui(),
                employee.fullName(),
                employee.eventDate()
        );
    }

    private static <T> List<T> safe(List<T> list) {
        return list == null ? List.of() : list;
    }
}
