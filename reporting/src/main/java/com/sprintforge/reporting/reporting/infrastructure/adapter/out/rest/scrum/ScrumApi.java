package com.sprintforge.reporting.reporting.infrastructure.adapter.out.rest.scrum;

import com.sprintforge.common.application.exception.BusinessException;
import com.sprintforge.common.application.port.result.ProjectProgressReportResult;
import com.sprintforge.common.infrastructure.adapter.in.rest.dto.ProjectProgressReportResponseDTO;
import com.sprintforge.reporting.reporting.application.port.out.rest.scrum.GetProjectProgressReport;
import com.sprintforge.reporting.reporting.application.port.out.rest.scrum.GetProjectProgressReportQuery;
import com.sprintforge.reporting.reporting.infrastructure.adapter.out.rest.scrum.mapper.ProjectProgressReportResultMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClient;

import static com.sprintforge.common.infrastructure.rest.error.RemoteProblemDetailExtractor.extractDetailOrRaw;

@Component
@RequiredArgsConstructor
public class ScrumApi implements GetProjectProgressReport {

    private static final String INTERNAL_PROJECT_BASE_PATH =
            "/internal-api/v1/project";

    private static final String GET_PROJECT_PROGRESS_PATH =
            INTERNAL_PROJECT_BASE_PATH + "/progress-report";

    private final RestClient scrumRestClient;

    @Override
    public ProjectProgressReportResult handle(GetProjectProgressReportQuery query) {
        try {
            ProjectProgressReportResponseDTO response =
                    scrumRestClient.get()
                            .uri(uriBuilder -> uriBuilder
                                    .path(GET_PROJECT_PROGRESS_PATH)
                                    .queryParam("projectId", query.projectId())
                                    .build()
                            )
                            .retrieve()
                            .body(ProjectProgressReportResponseDTO.class);
            if (response == null) {
                throw new BusinessException("No se pudo obtener el reporte de progreso de proyectos");
            }
            return ProjectProgressReportResultMapper.toResult(response);
        } catch (HttpClientErrorException.Conflict ex) {
            throw new BusinessException(extractDetailOrRaw(ex.getResponseBodyAsString()));
        }
    }
}
