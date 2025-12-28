package com.sprintforge.reporting.reporting.application.port.out.persistence;

import com.sprintforge.reporting.reporting.domain.project.DimProject;

public interface SaveDimProject {
    void save(DimProject dimProject);
}
