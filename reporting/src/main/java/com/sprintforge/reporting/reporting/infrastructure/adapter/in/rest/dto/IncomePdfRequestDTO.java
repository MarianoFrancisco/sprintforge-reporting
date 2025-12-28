package com.sprintforge.reporting.reporting.infrastructure.adapter.in.rest.dto;

import com.sprintforge.common.infrastructure.validation.END_AFTER_START;
import com.sprintforge.reporting.reporting.application.service.internal.IncomeSubtotal;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.UUID;

@END_AFTER_START(
        start = "from",
        end = "to",
        allowEqual = true,
        message = "La fecha de fin no puede ser anterior a la fecha de inicio"
)
public record IncomePdfRequestDTO(
        @NotNull(message = "La fecha de inicio es obligatoria")
        LocalDate from,

        @NotNull(message = "La fecha de fin es obligatoria")
        LocalDate to,

        @NotNull(message = "El tipo de subtotal es obligatorio")
        IncomeSubtotal subtotalType,

        UUID projectId
) {
}
