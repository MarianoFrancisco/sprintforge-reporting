package com.sprintforge.reporting.reporting.application.service;

import com.sprintforge.common.application.port.result.EmployeeProductivityReportResult;
import com.sprintforge.reporting.reporting.application.port.in.query.GetEmployeeProductivityPdf;
import com.sprintforge.reporting.reporting.application.port.in.query.GetEmployeeProductivityPdfQuery;
import com.sprintforge.reporting.reporting.application.port.out.renderer.ReportRenderer;
import com.sprintforge.reporting.reporting.application.port.out.rest.scrum.GetEmployeeProductivityReport;
import com.sprintforge.reporting.reporting.application.port.out.rest.scrum.GetEmployeeProductivityReportQuery;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class GetEmployeeProductivityPdfImpl implements GetEmployeeProductivityPdf {

    private final GetEmployeeProductivityReport getEmployeeProductivityReport;

    private final ReportRenderer reportRenderer;

    @Override
    public byte[] handle(GetEmployeeProductivityPdfQuery query) {
        EmployeeProductivityReportResult result =
                getEmployeeProductivityReport.handle(
                        new GetEmployeeProductivityReportQuery(
                                query.from(),
                                query.to(),
                                query.employeeId()
                        )
                );

        return reportRenderer.render("reports/employee-productivity", Map.of("result", result));
    }
}
