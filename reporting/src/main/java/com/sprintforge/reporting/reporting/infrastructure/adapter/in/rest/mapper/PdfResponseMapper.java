package com.sprintforge.reporting.reporting.infrastructure.adapter.in.rest.mapper;

import lombok.experimental.UtilityClass;
import org.jspecify.annotations.NonNull;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.util.UUID;

@UtilityClass
public final class PdfResponseMapper {
    public ResponseEntity<byte @NonNull []> projectProgress(
            byte @NonNull [] pdf,
            UUID projectId
    ) {
        String suffix = (projectId == null) ? "all" : projectId.toString();
        return buildWithSuffix(pdf, "project-progress", suffix);
    }

    public ResponseEntity<byte @NonNull []> employeeProductivity(
            byte @NonNull [] pdf,
            UUID employeeId
    ) {
        String suffix = (employeeId == null) ? "all" : employeeId.toString();
        return buildWithSuffix(pdf, "employee-productivity", suffix);
    }

    public ResponseEntity<byte @NonNull []> hiringHistory(
            byte @NonNull [] pdf,
            LocalDate from,
            LocalDate to
    ) {
        return buildWithRange(pdf, "hiring-history", from, to);
    }

    public ResponseEntity<byte @NonNull []> terminationHistory(
            byte @NonNull [] pdf,
            LocalDate from,
            LocalDate to
    ) {
        return buildWithRange(pdf, "termination-history", from, to);
    }

    public ResponseEntity<byte @NonNull []> roleGeneral(
            byte @NonNull [] pdf
    ) {
        return buildWithSuffix(pdf, "role-general", "all");
    }

    public ResponseEntity<byte @NonNull []> income(
            byte @NonNull [] pdf,
            LocalDate from,
            LocalDate to
    ) {
        return buildWithRange(pdf, "income", from, to);
    }

    public ResponseEntity<byte @NonNull []> expense(
            byte @NonNull [] pdf,
            LocalDate from,
            LocalDate to
    ) {
        return buildWithRange(pdf, "expense", from, to);
    }

    public ResponseEntity<byte @NonNull []> profit(
            byte @NonNull [] pdf,
            LocalDate from,
            LocalDate to
    ) {
        return buildWithRange(pdf, "profit", from, to);
    }

    private static ResponseEntity<byte @NonNull []> buildWithRange(
            byte @NonNull [] pdf,
            String prefix,
            LocalDate from,
            LocalDate to
    ) {
        String range = buildRangeLabel(from, to);
        return buildWithSuffix(pdf, prefix, range);
    }

    private static ResponseEntity<byte @NonNull []> buildWithSuffix(
            byte @NonNull [] pdf,
            String prefix,
            String suffix
    ) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);

        String filename = prefix + "_" + suffix + ".pdf";

        ContentDisposition disposition = ContentDisposition
                .attachment()
                .filename(filename)
                .build();

        headers.setContentDisposition(disposition);

        return ResponseEntity
                .ok()
                .headers(headers)
                .body(pdf);
    }

    private static String buildRangeLabel(LocalDate from, LocalDate to) {
        if (from == null && to == null) {
            return "all";
        }
        if (from != null && to != null) {
            return from + "_" + to;
        }
        if (from != null) {
            return from + "_to-all";
        }
        return "all_to-" + to;
    }
}
