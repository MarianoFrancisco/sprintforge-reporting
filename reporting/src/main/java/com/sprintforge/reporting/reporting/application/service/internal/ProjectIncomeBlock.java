package com.sprintforge.reporting.reporting.application.service.internal;

import java.math.BigDecimal;
import java.util.List;

public record ProjectIncomeBlock(
        ProjectTotalRow project,
        String subtotalLabel,
        List<IncomePaymentRow> payments,
        BigDecimal subtotal
) {
}
