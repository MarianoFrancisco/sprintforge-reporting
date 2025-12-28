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
@Table(name = "dim_project")
public class DimProjectEntity {

    @Id
    @Column(name = "project_id")
    private UUID projectId;

    @Column(name = "project_key", nullable = false, unique = true, length = 10)
    private String projectKey;

    @Column(name = "name", nullable = false, unique = true, length = 50)
    private String name;

    @Column(name = "client", nullable = false, length = 100)
    private String client;

    @Column(name = "area", nullable = false, length = 80)
    private String area;

    @Column(name = "is_closed", nullable = false)
    private boolean isClosed;

    @Column(name = "is_deleted", nullable = false)
    private boolean isDeleted;
}
