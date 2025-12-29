package com.sprintforge.reporting.reporting.application.port.out.rest.identity;

import com.sprintforge.common.application.port.result.RoleGeneralReportResult;

public interface GetRoleGeneralReport {
    RoleGeneralReportResult handle(GetRoleGeneralReportQuery query);
}
