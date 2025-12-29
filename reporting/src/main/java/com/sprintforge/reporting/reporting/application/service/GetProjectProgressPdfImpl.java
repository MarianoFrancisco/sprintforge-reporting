package com.sprintforge.reporting.reporting.application.service;

import com.sprintforge.common.application.port.result.ProjectProgressReportResult;
import com.sprintforge.reporting.reporting.application.port.in.query.GetProjectProgressPdf;
import com.sprintforge.reporting.reporting.application.port.in.query.GetProjectProgressPdfQuery;
import com.sprintforge.reporting.reporting.application.port.out.renderer.ReportRenderer;
import com.sprintforge.reporting.reporting.application.port.out.rest.scrum.GetProjectProgressReport;
import com.sprintforge.reporting.reporting.application.port.out.rest.scrum.GetProjectProgressReportQuery;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class GetProjectProgressPdfImpl implements GetProjectProgressPdf {

    private final GetProjectProgressReport getProjectProgressReport;

    private final ReportRenderer reportRenderer;

    @Override
    public byte[] handle(GetProjectProgressPdfQuery query) {
        ProjectProgressReportResult result =
                getProjectProgressReport.handle(
                        new GetProjectProgressReportQuery(
                                query.projectId()
                        )
                );

        return reportRenderer.render("reports/project-progress", Map.of("result", result));
    }
}
