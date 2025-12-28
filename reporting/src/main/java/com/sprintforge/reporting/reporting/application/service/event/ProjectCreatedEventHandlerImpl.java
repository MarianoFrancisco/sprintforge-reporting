package com.sprintforge.reporting.reporting.application.service.event;

import com.sprintforge.reporting.reporting.application.mapper.DimProjectMapper;
import com.sprintforge.reporting.reporting.application.port.in.event.project.ProjectCreatedEventHandler;
import com.sprintforge.reporting.reporting.application.port.in.event.project.ProjectCreatedIntegrationEvent;
import com.sprintforge.reporting.reporting.application.port.out.persistence.SaveDimProject;
import com.sprintforge.reporting.reporting.domain.project.DimProject;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(rollbackFor = Exception.class)
public class ProjectCreatedEventHandlerImpl implements ProjectCreatedEventHandler {

    private final SaveDimProject saveDimProject;

    @Override
    public void handle(ProjectCreatedIntegrationEvent event) {
        DimProject dimEmployee = DimProjectMapper.toDomain(event);
        saveDimProject.save(dimEmployee);
    }
}
