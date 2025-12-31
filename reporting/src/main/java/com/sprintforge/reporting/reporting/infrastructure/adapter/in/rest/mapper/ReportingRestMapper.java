package com.sprintforge.reporting.reporting.infrastructure.adapter.in.rest.mapper;

import com.sprintforge.reporting.reporting.application.port.in.query.*;
import com.sprintforge.reporting.reporting.application.port.out.rest.employee.*;
import com.sprintforge.reporting.reporting.infrastructure.adapter.in.rest.dto.*;
import lombok.experimental.UtilityClass;

@UtilityClass
public class ReportingRestMapper {
    public GetProjectProgressPdfQuery toQuery(ProjectProgressPdfRequestDTO dto) {
        return new GetProjectProgressPdfQuery(
                dto.projectId()
        );
    }

    public GetEmployeeProductivityPdfQuery toQuery(EmployeeProductivityPdfRequestDTO dto) {
        return new GetEmployeeProductivityPdfQuery(
                dto.from(),
                dto.to(),
                dto.employeeId()
        );
    }

    public GetHiringHistoryPdfQuery toQuery(HiringHistoryPdfRequestDTO dto) {
        return new GetHiringHistoryPdfQuery(
                dto.from(),
                dto.to()
        );
    }

    public GetTerminationHistoryPdfQuery toQuery(TerminationHistoryPdfRequestDTO dto) {
        return new GetTerminationHistoryPdfQuery(
                dto.from(),
                dto.to()
        );
    }

    public GetRoleGeneralPdfQuery toQuery(RoleGeneralPdfRequestDTO dto) {
        return new GetRoleGeneralPdfQuery(
        );
    }

    public GetIncomePdfQuery toQuery(IncomePdfRequestDTO dto) {
        return new GetIncomePdfQuery(
                dto.from(),
                dto.to(),
                dto.subtotalType(),
                dto.projectId()
        );
    }

    public GetExpensePdfQuery toQuery(ExpensePdfRequestDTO dto) {
        return new GetExpensePdfQuery(
                dto.from(),
                dto.to()
        );
    }

    public GetProfitPdfQuery toQuery(ProfitPdfRequestDTO dto) {
        return new GetProfitPdfQuery(
                dto.from(),
                dto.to()
        );
    }
}
