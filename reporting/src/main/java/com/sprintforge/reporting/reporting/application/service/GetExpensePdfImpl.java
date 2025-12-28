package com.sprintforge.reporting.reporting.application.service;

import com.sprintforge.reporting.reporting.application.port.in.query.GetExpensePdf;
import com.sprintforge.reporting.reporting.application.port.in.query.GetExpensePdfQuery;
import com.sprintforge.reporting.reporting.application.port.out.persistence.LoadExpense;
import com.sprintforge.reporting.reporting.application.port.out.renderer.ReportRenderer;
import com.sprintforge.reporting.reporting.application.service.internal.Expense;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class GetExpensePdfImpl implements GetExpensePdf {

    private final LoadExpense loadExpense;

    private final ReportRenderer reportRenderer;

    @Override
    public byte[] handle(GetExpensePdfQuery query) {
        Expense result = loadExpense.loadExpense(
                query.from(),
                query.to()
        );
        return reportRenderer.render("reports/expense", Map.of("result", result));
    }
}
