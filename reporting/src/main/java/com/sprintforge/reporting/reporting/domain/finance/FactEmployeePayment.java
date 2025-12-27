package com.sprintforge.reporting.reporting.domain.finance;

import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Getter
public class FactEmployeePayment {
    UUID paymentId;
    UUID employeeId;
    LocalDate date;
    BigDecimal baseSalary;
    BigDecimal bonus;
    BigDecimal deduction;
    BigDecimal total;

    public FactEmployeePayment(
            UUID paymentId,
            UUID employeeId,
            LocalDate date,
            BigDecimal baseSalary,
            BigDecimal bonus,
            BigDecimal deduction,
            BigDecimal total
    ) {
        this.paymentId = paymentId;
        this.employeeId = employeeId;
        this.date = date;
        this.baseSalary = baseSalary;
        this.bonus = bonus;
        this.deduction = deduction;
        this.total = total;
    }
}
