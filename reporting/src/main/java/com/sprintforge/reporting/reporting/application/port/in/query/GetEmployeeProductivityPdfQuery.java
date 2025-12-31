package com.sprintforge.reporting.reporting.application.port.in.query;

import java.time.LocalDate;
import java.util.UUID;

public record GetEmployeeProductivityPdfQuery(
        LocalDate from,
        LocalDate to,
        UUID employeeId
) {
}
