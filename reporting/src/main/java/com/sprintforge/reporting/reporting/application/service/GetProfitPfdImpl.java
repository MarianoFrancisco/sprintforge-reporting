package com.sprintforge.reporting.reporting.application.service;

import com.sprintforge.reporting.reporting.application.port.in.query.GetProfitPdf;
import com.sprintforge.reporting.reporting.application.port.in.query.GetProfitPdfQuery;
import com.sprintforge.reporting.reporting.application.port.out.persistence.LoadProfit;
import com.sprintforge.reporting.reporting.application.port.out.renderer.ReportRenderer;
import com.sprintforge.reporting.reporting.application.service.internal.Profit;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class GetProfitPfdImpl implements GetProfitPdf {

    private final LoadProfit loadProfit;

    private final ReportRenderer reportRenderer;

    @Override
    public byte[] handle(GetProfitPdfQuery query) {
        Profit result = loadProfit.loadProfit(
                query.from(),
                query.to()
        );
        return reportRenderer.render("reports/profit", Map.of("result", result));
    }
}
