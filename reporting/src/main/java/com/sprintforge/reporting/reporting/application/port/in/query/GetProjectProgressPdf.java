package com.sprintforge.reporting.reporting.application.port.in.query;

public interface GetProjectProgressPdf {
    byte[] handle(GetProjectProgressPdfQuery query);
}
