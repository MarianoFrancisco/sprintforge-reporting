package com.sprintforge.reporting.reporting.application.service.internal;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

public record EmployeeExpenseDetail(
        UUID employeeId,
        String fullName,
        List<EmployeePaymentRow> payments,
        BigDecimal subtotal
) {
}
