package com.sprintforge.reporting.reporting.application.port.out.rest.employee;

import com.sprintforge.common.application.port.result.ProjectProgressReportResult;

public interface GetProjectProgressReport {
    ProjectProgressReportResult handle(GetProjectProgressReportQuery query);
}
