package com.sprintforge.reporting.reporting.infrastructure.adapter.in.rest.mapper;

import com.sprintforge.reporting.reporting.application.port.in.query.GetExpensePdfQuery;
import com.sprintforge.reporting.reporting.application.port.in.query.GetIncomePdfQuery;
import com.sprintforge.reporting.reporting.application.port.in.query.GetProfitPdfQuery;
import com.sprintforge.reporting.reporting.infrastructure.adapter.in.rest.dto.ExpensePdfRequestDTO;
import com.sprintforge.reporting.reporting.infrastructure.adapter.in.rest.dto.IncomePdfRequestDTO;
import com.sprintforge.reporting.reporting.infrastructure.adapter.in.rest.dto.ProfitPdfRequestDTO;
import lombok.experimental.UtilityClass;

@UtilityClass
public class ReportingRestMapper {

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
