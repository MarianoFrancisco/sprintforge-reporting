package com.sprintforge.reporting.reporting.application.port.out.rest.scrum;

import java.time.LocalDate;
import java.util.UUID;

public record GetEmployeeProductivityReportQuery(
        LocalDate from,
        LocalDate to,
        UUID employeeId
) {
}
