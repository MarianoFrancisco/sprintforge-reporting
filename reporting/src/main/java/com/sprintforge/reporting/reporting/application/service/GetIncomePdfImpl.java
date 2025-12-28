package com.sprintforge.reporting.reporting.application.service;

import com.sprintforge.reporting.reporting.application.port.in.query.GetIncomePdf;
import com.sprintforge.reporting.reporting.application.port.in.query.GetIncomePdfQuery;
import com.sprintforge.reporting.reporting.application.port.out.persistence.LoadIncome;
import com.sprintforge.reporting.reporting.application.port.out.renderer.ReportRenderer;
import com.sprintforge.reporting.reporting.application.service.internal.Income;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class GetIncomePdfImpl implements GetIncomePdf {

    private final LoadIncome loadIncome;

    private final ReportRenderer reportRenderer;

    @Override
    public byte[] handle(GetIncomePdfQuery query) {
        Income result = loadIncome.loadIncome(
                query.from(),
                query.to(),
                query.subtotalType(),
                query.projectId()
        );
        return reportRenderer.render("reports/income", Map.of("result", result));
    }
}
