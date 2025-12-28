package com.sprintforge.reporting.reporting.application.port.in.query;

import java.time.LocalDate;

public record GetProfitPdfQuery(
        LocalDate from,
        LocalDate to
) {}
