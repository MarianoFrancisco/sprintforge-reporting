package com.sprintforge.reporting.reporting.application.port.in.query;

public interface GetTerminationHistoryPdf {
    byte[] handle(GetTerminationHistoryPdfQuery query);
}
