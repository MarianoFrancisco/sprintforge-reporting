package com.sprintforge.reporting.reporting.application.port.out.rest.scrum;

import com.sprintforge.common.application.port.result.EmployeeProductivityReportResult;

public interface GetEmployeeProductivityReport {
    EmployeeProductivityReportResult handle(GetEmployeeProductivityReportQuery query);
}
