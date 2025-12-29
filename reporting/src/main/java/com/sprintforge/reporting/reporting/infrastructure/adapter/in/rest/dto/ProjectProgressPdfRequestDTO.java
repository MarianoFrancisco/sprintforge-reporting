package com.sprintforge.reporting.reporting.infrastructure.adapter.in.rest.dto;

import java.util.UUID;

public record ProjectProgressPdfRequestDTO(
        UUID projectId
) {
}
