package com.sprintforge.reporting.reporting.infrastructure.adapter.out.rest.identity;

import com.sprintforge.common.application.exception.BusinessException;
import com.sprintforge.common.application.port.result.RoleGeneralReportResult;
import com.sprintforge.common.infrastructure.adapter.in.rest.dto.RoleGeneralReportResponseDTO;
import com.sprintforge.reporting.reporting.application.port.out.rest.identity.GetRoleGeneralReport;
import com.sprintforge.reporting.reporting.application.port.out.rest.identity.GetRoleGeneralReportQuery;
import com.sprintforge.reporting.reporting.infrastructure.adapter.out.rest.identity.mapper.RoleGeneralReportResultMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClient;

import static com.sprintforge.common.infrastructure.rest.error.RemoteProblemDetailExtractor.extractDetailOrRaw;

@Component
@RequiredArgsConstructor
public class IdentityApi implements GetRoleGeneralReport {

    private static final String INTERNAL_ROLE_BASE_PATH =
            "/internal-api/v1/role";

    private static final String GET_GENERAL_REPORT_PATH =
            INTERNAL_ROLE_BASE_PATH + "/general-report";

    private final RestClient identityRestClient;

    @Override
    public RoleGeneralReportResult handle(GetRoleGeneralReportQuery query) {
        try {
            RoleGeneralReportResponseDTO response =
                    identityRestClient.get()
                            .uri(uriBuilder -> uriBuilder
                                    .path(GET_GENERAL_REPORT_PATH)
                                    .build()
                            )
                            .retrieve()
                            .body(RoleGeneralReportResponseDTO.class);
            if (response == null) {
                throw new BusinessException("No se pudo obtener el reporte general de roles");
            }
            return RoleGeneralReportResultMapper.toResult(response);
        } catch (HttpClientErrorException.Conflict ex) {
            throw new BusinessException(extractDetailOrRaw(ex.getResponseBodyAsString()));
        }
    }
}
