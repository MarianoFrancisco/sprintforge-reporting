package com.sprintforge.reporting.reporting.domain.project;

import lombok.Getter;

import java.util.UUID;

@Getter
public class DimProject {
    UUID projectId;
    String projectKey;
    String name;
    String client;
    String area;
    boolean isClosed;
    boolean isDeleted;

    public DimProject(
            UUID projectId,
            String projectKey,
            String name,
            String client,
            String area,
            boolean isClosed,
            boolean isDeleted
    ) {
        this.projectId = projectId;
        this.projectKey = projectKey;
        this.name = name;
        this.client = client;
        this.area = area;
        this.isClosed = isClosed;
        this.isDeleted = isDeleted;
    }
}
