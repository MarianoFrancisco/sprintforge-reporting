package com.sprintforge.reporting.reporting.infrastructure.adapter.out.persistence.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "dim_employee")
public class DimEmployeeEntity {

    @Id
    @Column(name = "employee_id")
    private UUID employeeId;

    @Column(name = "full_name", nullable = false, length = 201)
    private String fullName;

    @Column(name = "status", nullable = false, length = 20)
    private String status;
}
