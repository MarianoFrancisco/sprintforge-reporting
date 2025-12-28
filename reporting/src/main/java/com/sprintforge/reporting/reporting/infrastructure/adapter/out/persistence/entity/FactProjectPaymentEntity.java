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
@Table(name = "fact_project_payment",
        indexes = {
                @Index(name = "idx_fact_project_payment_project_date", columnList = "project_id, date"),
                @Index(name = "idx_fact_project_payment_date", columnList = "date")
        })
public class FactProjectPaymentEntity {

    @Id
    @Column(name = "payment_id")
    private UUID paymentId;

    @Column(name = "project_id", nullable = false)
    private UUID projectId;

    @Column(name = "date", nullable = false)
    private LocalDate date;

    @Column(name = "amount", nullable = false, precision = 12, scale = 2)
    private BigDecimal amount;

    @Column(name = "method", nullable = false, length = 20)
    private String method;
}
