package com.sprintforge.reporting.reporting.infrastructure.adapter.in.rest.controller;

import com.sprintforge.reporting.reporting.application.port.in.query.*;
import com.sprintforge.reporting.reporting.infrastructure.adapter.in.rest.dto.*;
import com.sprintforge.reporting.reporting.infrastructure.adapter.in.rest.mapper.PdfResponseMapper;
import com.sprintforge.reporting.reporting.infrastructure.adapter.in.rest.mapper.ReportingRestMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.jspecify.annotations.NonNull;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.MediaType.APPLICATION_PDF_VALUE;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/reporting")
public class ReportingController {

    private final GetProjectProgressPdf getProjectProgressPdf;
    private final GetHiringHistoryPdf getHiringHistoryPdf;
    private final GetTerminationHistoryPdf getTerminationHistoryPdf;
    private final GetRoleGeneralPdf getRoleGeneralPdf;
    private final GetIncomePdf getIncomePdf;
    private final GetExpensePdf getExpensePdf;
    private final GetProfitPdf getProfitPdf;

    @GetMapping(value = "/project-progress.pdf", produces = APPLICATION_PDF_VALUE)
    public ResponseEntity<byte @NonNull []> projectProgressPdf(
            @Valid @ModelAttribute ProjectProgressPdfRequestDTO dto
    ) {
        byte[] pdf = getProjectProgressPdf.handle(
                ReportingRestMapper.toQuery(dto)
        );
        return PdfResponseMapper.projectProgress(pdf, dto.projectId());
    }

    @GetMapping(value = "/hiring-history.pdf", produces = APPLICATION_PDF_VALUE)
    public ResponseEntity<byte @NonNull []> hiringHistoryPdf(
            @Valid @ModelAttribute HiringHistoryPdfRequestDTO dto
    ) {
        byte[] pdf = getHiringHistoryPdf.handle(
                ReportingRestMapper.toQuery(dto)
        );
        return PdfResponseMapper.hiringHistory(pdf, dto.from(), dto.to());
    }

    @GetMapping(value = "/termination-history.pdf", produces = APPLICATION_PDF_VALUE)
    public ResponseEntity<byte @NonNull []> terminationHistoryPdf(
            @Valid @ModelAttribute TerminationHistoryPdfRequestDTO dto
    ) {
        byte[] pdf = getTerminationHistoryPdf.handle(
                ReportingRestMapper.toQuery(dto)
        );
        return PdfResponseMapper.terminationHistory(pdf, dto.from(), dto.to());
    }

    @GetMapping(value = "/role-general.pdf", produces = APPLICATION_PDF_VALUE)
    public ResponseEntity<byte @NonNull []> roleGeneralPdf(
            @Valid @ModelAttribute RoleGeneralPdfRequestDTO dto
    ) {
        byte[] pdf = getRoleGeneralPdf.handle(
                ReportingRestMapper.toQuery(dto)
        );
        return PdfResponseMapper.roleGeneral(pdf);
    }

    @GetMapping(value = "/income.pdf", produces = APPLICATION_PDF_VALUE)
    public ResponseEntity<byte @NonNull []> incomePdf(
            @Valid @ModelAttribute IncomePdfRequestDTO dto
    ) {
        byte[] pdf = getIncomePdf.handle(
                ReportingRestMapper.toQuery(dto)
        );
        return PdfResponseMapper.income(pdf, dto.from(), dto.to());
    }

    @GetMapping(value = "/expense.pdf", produces = APPLICATION_PDF_VALUE)
    public ResponseEntity<byte @NonNull []> expensePdf(
            @Valid @ModelAttribute ExpensePdfRequestDTO dto
    ) {
        byte[] pdf = getExpensePdf.handle(
                ReportingRestMapper.toQuery(dto)
        );
        return PdfResponseMapper.expense(pdf, dto.from(), dto.to());
    }

    @GetMapping(value = "/profit.pdf", produces = APPLICATION_PDF_VALUE)
    public ResponseEntity<byte @NonNull []> profitPdf(
            @Valid @ModelAttribute ProfitPdfRequestDTO dto
    ) {
        byte[] pdf = getProfitPdf.handle(
                ReportingRestMapper.toQuery(dto)
        );
        return PdfResponseMapper.profit(pdf, dto.from(), dto.to());
    }
}
