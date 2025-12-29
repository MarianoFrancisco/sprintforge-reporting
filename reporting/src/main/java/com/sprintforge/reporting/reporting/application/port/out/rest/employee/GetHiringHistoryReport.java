package com.sprintforge.reporting.reporting.application.port.out.rest.employee;

import com.sprintforge.common.application.port.result.EmployeesByEmploymentHistoryReportResult;

public interface GetHiringHistoryReport {
    EmployeesByEmploymentHistoryReportResult handle(GetHiringHistoryReportQuery query);
}
