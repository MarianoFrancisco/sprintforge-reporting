package com.sprintforge.reporting.reporting.infrastructure.adapter.in.rest.mapper;

import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;

public final class PdfResponseMapper {

    private PdfResponseMapper() {
    }

    public static ResponseEntity<byte[]> income(
            byte[] pdf,
            LocalDate from,
            LocalDate to
    ) {
        return build(pdf, "income", from, to);
    }

    public static ResponseEntity<byte[]> expense(
            byte[] pdf,
            LocalDate from,
            LocalDate to
    ) {
        return build(pdf, "expense", from, to);
    }

    public static ResponseEntity<byte[]> profit(
            byte[] pdf,
            LocalDate from,
            LocalDate to
    ) {
        return build(pdf, "profit", from, to);
    }

    private static ResponseEntity<byte[]> build(
            byte[] pdf,
            String prefix,
            LocalDate from,
            LocalDate to
    ) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);

        String filename = prefix + "_" + from + "_" + to + ".pdf";

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
}
