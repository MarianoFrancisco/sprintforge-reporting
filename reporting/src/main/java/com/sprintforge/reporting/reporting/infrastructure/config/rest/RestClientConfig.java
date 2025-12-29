package com.sprintforge.reporting.reporting.infrastructure.config.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

@Configuration
@RequiredArgsConstructor
public class RestClientConfig {

    private final UrlProperties urlProperties;

    @Bean
    public RestClient identityRestClient() {
        return RestClient.builder()
                .baseUrl(urlProperties.identity())
                .build();
    }

    @Bean
    public RestClient employeeRestClient() {
        return RestClient.builder()
                .baseUrl(urlProperties.employee())
                .build();
    }

    @Bean
    public RestClient scrumRestClient() {
        return RestClient.builder()
                .baseUrl(urlProperties.scrum())
                .build();
    }
}
