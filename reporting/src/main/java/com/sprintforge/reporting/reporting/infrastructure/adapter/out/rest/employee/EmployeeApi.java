package com.sprintforge.reporting.reporting.infrastructure.adapter.out.rest.employee;

import com.sprintforge.common.application.exception.BusinessException;
import com.sprintforge.common.application.port.result.EmployeesByEmploymentHistoryReportResult;
import com.sprintforge.common.infrastructure.adapter.in.rest.dto.EmployeesByEmploymentHistoryReportResponseDTO;
import com.sprintforge.reporting.reporting.application.port.out.rest.employee.GetHiringHistoryReport;
import com.sprintforge.reporting.reporting.application.port.out.rest.employee.GetHiringHistoryReportQuery;
import com.sprintforge.reporting.reporting.application.port.out.rest.employee.GetTerminationHistoryReport;
import com.sprintforge.reporting.reporting.application.port.out.rest.employee.GetTerminationHistoryReportQuery;
import com.sprintforge.reporting.reporting.infrastructure.adapter.out.rest.employee.mapper.EmployeesByEmploymentHistoryReportResultMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClient;

import static com.sprintforge.common.infrastructure.rest.error.RemoteProblemDetailExtractor.extractDetailOrRaw;

@Component
@RequiredArgsConstructor
public class EmployeeApi implements
        GetHiringHistoryReport,
        GetTerminationHistoryReport {

    private static final String INTERNAL_EMPLOYMENT_HISTORY_PATH =
            "/internal-api/v1/employee/history";

    private static final String GET_HIRING_HISTORY_PATH =
            INTERNAL_EMPLOYMENT_HISTORY_PATH + "/hiring-report";

    private static final String GET_TERMINATION_HISTORY_PATH =
            INTERNAL_EMPLOYMENT_HISTORY_PATH + "/termination-report";

    private final RestClient employeeRestClient;

    @Override
    public EmployeesByEmploymentHistoryReportResult handle(GetHiringHistoryReportQuery query) {
        try {
            EmployeesByEmploymentHistoryReportResponseDTO response =
                    employeeRestClient.get()
                            .uri(uriBuilder -> uriBuilder
                                    .path(GET_HIRING_HISTORY_PATH)
                                    .queryParam("from", query.from())
                                    .queryParam("to", query.to())
                                    .build()
                            )
                            .retrieve()
                            .body(EmployeesByEmploymentHistoryReportResponseDTO.class);
            if (response == null) {
                throw new BusinessException("No se pudo obtener el reporte de historial de contrataciones");
            }
            return EmployeesByEmploymentHistoryReportResultMapper.toResult(response);
        } catch (HttpClientErrorException.Conflict ex) {
            throw new BusinessException(extractDetailOrRaw(ex.getResponseBodyAsString()));
        }
    }

    @Override
    public EmployeesByEmploymentHistoryReportResult handle(GetTerminationHistoryReportQuery query) {
        try {
            EmployeesByEmploymentHistoryReportResponseDTO response =
                    employeeRestClient.get()
                            .uri(uriBuilder -> uriBuilder
                                    .path(GET_TERMINATION_HISTORY_PATH)
                                    .queryParam("from", query.from())
                                    .queryParam("to", query.to())
                                    .build()
                            )
                            .retrieve()
                            .body(EmployeesByEmploymentHistoryReportResponseDTO.class);
            if (response == null) {
                throw new BusinessException("No se pudo obtener el reporte de historial de retirados");
            }
            return EmployeesByEmploymentHistoryReportResultMapper.toResult(response);
        } catch (HttpClientErrorException.Conflict ex) {
            throw new BusinessException(extractDetailOrRaw(ex.getResponseBodyAsString()));
        }
    }
}
