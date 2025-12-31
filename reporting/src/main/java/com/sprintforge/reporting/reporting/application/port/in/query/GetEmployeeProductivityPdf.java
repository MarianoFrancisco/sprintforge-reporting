package com.sprintforge.reporting.reporting.application.port.in.query;

public interface GetEmployeeProductivityPdf {
    byte[] handle(GetEmployeeProductivityPdfQuery query);
}
