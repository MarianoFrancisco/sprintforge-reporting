package com.sprintforge.reporting.reporting.application.service;

import com.sprintforge.common.application.port.result.EmployeesByEmploymentHistoryReportResult;
import com.sprintforge.reporting.reporting.application.port.in.query.GetTerminationHistoryPdf;
import com.sprintforge.reporting.reporting.application.port.in.query.GetTerminationHistoryPdfQuery;
import com.sprintforge.reporting.reporting.application.port.out.renderer.ReportRenderer;
import com.sprintforge.reporting.reporting.application.port.out.rest.employee.GetTerminationHistoryReport;
import com.sprintforge.reporting.reporting.application.port.out.rest.employee.GetTerminationHistoryReportQuery;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class GetTerminationHistoryPdfImpl implements GetTerminationHistoryPdf {

    private final GetTerminationHistoryReport getTerminationHistoryReport;

    private final ReportRenderer reportRenderer;

    @Override
    public byte[] handle(GetTerminationHistoryPdfQuery query) {
        EmployeesByEmploymentHistoryReportResult result =
                getTerminationHistoryReport.handle(
                        new GetTerminationHistoryReportQuery(
                                query.from(),
                                query.to()
                        )
                );

        return reportRenderer.render("reports/termination-history", Map.of("result", result));
    }
}
