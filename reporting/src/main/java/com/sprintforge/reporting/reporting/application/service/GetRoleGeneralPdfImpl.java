package com.sprintforge.reporting.reporting.application.service;

import com.sprintforge.common.application.port.result.RoleGeneralReportResult;
import com.sprintforge.reporting.reporting.application.port.in.query.GetRoleGeneralPdf;
import com.sprintforge.reporting.reporting.application.port.in.query.GetRoleGeneralPdfQuery;
import com.sprintforge.reporting.reporting.application.port.out.renderer.ReportRenderer;
import com.sprintforge.reporting.reporting.application.port.out.rest.identity.GetRoleGeneralReport;
import com.sprintforge.reporting.reporting.application.port.out.rest.identity.GetRoleGeneralReportQuery;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class GetRoleGeneralPdfImpl implements GetRoleGeneralPdf {

    private final GetRoleGeneralReport getRoleGeneralReport;

    private final ReportRenderer reportRenderer;

    @Override
    public byte[] handle(GetRoleGeneralPdfQuery query) {
        RoleGeneralReportResult result =
                getRoleGeneralReport.handle(
                        new GetRoleGeneralReportQuery(
                        )
                );

        return reportRenderer.render("reports/role-general", Map.of("result", result));
    }
}
