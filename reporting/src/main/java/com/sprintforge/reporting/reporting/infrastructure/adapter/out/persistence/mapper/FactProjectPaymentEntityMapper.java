package com.sprintforge.reporting.reporting.infrastructure.adapter.out.persistence.mapper;

import com.sprintforge.reporting.reporting.domain.finance.FactProjectPayment;
import com.sprintforge.reporting.reporting.infrastructure.adapter.out.persistence.entity.FactProjectPaymentEntity;
import lombok.experimental.UtilityClass;

@UtilityClass
public class FactProjectPaymentEntityMapper {
    public FactProjectPaymentEntity toEntity(FactProjectPayment domain) {
        if (domain == null) {
            return null;
        }

        return FactProjectPaymentEntity.builder()
                .paymentId(domain.getPaymentId())
                .projectId(domain.getProjectId())
                .date(domain.getDate())
                .amount(domain.getAmount())
                .method(domain.getMethod().name())
                .build();
    }
}
