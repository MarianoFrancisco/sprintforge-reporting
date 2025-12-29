package com.sprintforge.reporting.reporting.application.service;

import com.sprintforge.common.application.port.result.EmployeesByEmploymentHistoryReportResult;
import com.sprintforge.reporting.reporting.application.port.in.query.GetHiringHistoryPdf;
import com.sprintforge.reporting.reporting.application.port.in.query.GetHiringHistoryPdfQuery;
import com.sprintforge.reporting.reporting.application.port.out.renderer.ReportRenderer;
import com.sprintforge.reporting.reporting.application.port.out.rest.employee.GetHiringHistoryReport;
import com.sprintforge.reporting.reporting.application.port.out.rest.employee.GetHiringHistoryReportQuery;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class GetHiringHistoryPdfImpl implements GetHiringHistoryPdf {

    private final GetHiringHistoryReport getHiringHistoryReport;

    private final ReportRenderer reportRenderer;

    @Override
    public byte[] handle(GetHiringHistoryPdfQuery query) {
        EmployeesByEmploymentHistoryReportResult result =
                getHiringHistoryReport.handle(
                        new GetHiringHistoryReportQuery(
                                query.from(),
                                query.to()
                        )
                );

        return reportRenderer.render("reports/hiring-history", Map.of("result", result));
    }
}
