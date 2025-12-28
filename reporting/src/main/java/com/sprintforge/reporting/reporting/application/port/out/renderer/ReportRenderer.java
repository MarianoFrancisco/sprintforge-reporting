package com.sprintforge.reporting.reporting.application.port.out.renderer;

import java.util.Map;

public interface ReportRenderer {
    byte[] render(String templateName, Map<String, Object> model);
}
