package com.sprintforge.reporting.reporting.application.port.out.rest.employee;

import java.time.LocalDate;

public record GetTerminationHistoryReportQuery(
        LocalDate from,
        LocalDate to
) {
}
