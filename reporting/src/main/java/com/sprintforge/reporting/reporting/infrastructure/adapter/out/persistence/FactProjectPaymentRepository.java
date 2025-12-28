package com.sprintforge.reporting.reporting.infrastructure.adapter.out.persistence;

import com.sprintforge.reporting.reporting.application.port.out.persistence.SaveFactProjectPayment;
import com.sprintforge.reporting.reporting.domain.finance.FactProjectPayment;
import com.sprintforge.reporting.reporting.infrastructure.adapter.out.persistence.entity.FactProjectPaymentEntity;
import com.sprintforge.reporting.reporting.infrastructure.adapter.out.persistence.mapper.FactProjectPaymentEntityMapper;
import com.sprintforge.reporting.reporting.infrastructure.adapter.out.persistence.repository.FactProjectPaymentJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class FactProjectPaymentRepository implements
        SaveFactProjectPayment {

    private final FactProjectPaymentJpaRepository factProjectPaymentJpaRepository;

    @Override
    public void save(FactProjectPayment factProjectPayment) {
        FactProjectPaymentEntity entity = FactProjectPaymentEntityMapper.toEntity(factProjectPayment);
        factProjectPaymentJpaRepository.save(entity);
    }
}
