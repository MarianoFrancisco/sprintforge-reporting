package com.sprintforge.reporting.reporting.application.service.event;

import com.sprintforge.reporting.reporting.application.mapper.DimEmployeeMapper;
import com.sprintforge.reporting.reporting.application.port.in.event.employee.EmployeeCreatedEventHandler;
import com.sprintforge.reporting.reporting.application.port.in.event.employee.EmployeeCreatedIntegrationEvent;
import com.sprintforge.reporting.reporting.application.port.out.persistence.SaveDimEmployee;
import com.sprintforge.reporting.reporting.domain.employee.DimEmployee;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(rollbackFor = Exception.class)
public class EmployeeCreatedEventHandlerImpl implements EmployeeCreatedEventHandler {

    private final SaveDimEmployee saveDimEmployee;

    @Override
    public void handle(EmployeeCreatedIntegrationEvent event) {
        DimEmployee dimEmployee = DimEmployeeMapper.toDomain(event);
        saveDimEmployee.save(dimEmployee);
    }
}
