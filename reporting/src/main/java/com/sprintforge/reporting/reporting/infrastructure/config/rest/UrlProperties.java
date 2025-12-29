package com.sprintforge.reporting.reporting.infrastructure.config.rest;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "urls")
public record UrlProperties(
        String identity,
        String employee,
        String scrum
) {
}
