package com.sprintforge.reporting.reporting.application.port.out.rest.scrum;

import com.sprintforge.common.application.port.result.ProjectProgressReportResult;

public interface GetProjectProgressReport {
    ProjectProgressReportResult handle(GetProjectProgressReportQuery query);
}
