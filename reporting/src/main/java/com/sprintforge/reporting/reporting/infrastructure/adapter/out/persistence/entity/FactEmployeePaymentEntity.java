package com.sprintforge.reporting.reporting.infrastructure.adapter.out.persistence.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "fact_employee_payment",
        indexes = {
                @Index(name = "idx_fact_employee_payment_employee_date", columnList = "employee_id, date"),
                @Index(name = "idx_fact_employee_payment_date", columnList = "date")
        })
public class FactEmployeePaymentEntity {

    @Id
    @Column(name = "payment_id")
    private UUID paymentId;

    @Column(name = "employee_id", nullable = false)
    private UUID employeeId;

    @Column(name = "date", nullable = false)
    private LocalDate date;

    @Column(name = "base_salary", nullable = false, precision = 10, scale = 2)
    private BigDecimal baseSalary;

    @Column(name = "bonus", nullable = false, precision = 10, scale = 2)
    private BigDecimal bonus;

    @Column(name = "deduction", nullable = false, precision = 10, scale = 2)
    private BigDecimal deduction;

    @Column(name = "total", nullable = false, precision = 10, scale = 2)
    private BigDecimal total;
}
