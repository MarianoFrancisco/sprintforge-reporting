package com.sprintforge.reporting.reporting.infrastructure.adapter.out.persistence.mapper;

import com.sprintforge.reporting.reporting.domain.finance.FactEmployeePayment;
import com.sprintforge.reporting.reporting.infrastructure.adapter.out.persistence.entity.FactEmployeePaymentEntity;
import lombok.experimental.UtilityClass;

@UtilityClass
public class FactEmployeePaymentEntityMapper {
    public FactEmployeePaymentEntity toEntity(FactEmployeePayment domain) {
        if (domain == null) {
            return null;
        }

        return FactEmployeePaymentEntity.builder()
                .paymentId(domain.getPaymentId())
                .employeeId(domain.getEmployeeId())
                .date(domain.getDate())
                .baseSalary(domain.getBaseSalary())
                .bonus(domain.getBonus())
                .deduction(domain.getDeduction())
                .total(domain.getTotal())
                .build();
    }
}
