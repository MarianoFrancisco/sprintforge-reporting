package com.sprintforge.reporting.reporting.infrastructure.adapter.out.persistence;

import com.sprintforge.reporting.reporting.application.port.out.persistence.SaveFactEmployeePayment;
import com.sprintforge.reporting.reporting.domain.finance.FactEmployeePayment;
import com.sprintforge.reporting.reporting.infrastructure.adapter.out.persistence.entity.FactEmployeePaymentEntity;
import com.sprintforge.reporting.reporting.infrastructure.adapter.out.persistence.mapper.FactEmployeePaymentEntityMapper;
import com.sprintforge.reporting.reporting.infrastructure.adapter.out.persistence.repository.FactEmployeePaymentJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class FactEmployeePaymentRepository implements
        SaveFactEmployeePayment {

    private final FactEmployeePaymentJpaRepository factEmployeePaymentJpaRepository;

    @Override
    public void save(FactEmployeePayment factEmployeePayment) {
        FactEmployeePaymentEntity entity = FactEmployeePaymentEntityMapper.toEntity(factEmployeePayment);
        factEmployeePaymentJpaRepository.save(entity);
    }
}
