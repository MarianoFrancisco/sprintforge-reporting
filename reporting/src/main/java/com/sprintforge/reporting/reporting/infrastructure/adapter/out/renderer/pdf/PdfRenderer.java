package com.sprintforge.reporting.reporting.infrastructure.adapter.out.renderer.pdf;

import com.sprintforge.reporting.reporting.application.port.out.renderer.ReportRenderer;
import org.springframework.stereotype.Component;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.xhtmlrenderer.pdf.ITextRenderer;

import java.io.ByteArrayOutputStream;
import java.util.Map;

@Component
public class PdfRenderer implements ReportRenderer {

    private final TemplateEngine templateEngine;

    public PdfRenderer(TemplateEngine templateEngine) {
        this.templateEngine = templateEngine;
    }

    @Override
    public byte[] render(String templateName, Map<String, Object> model) {
        Context context = new Context();
        context.setVariables(model);

        String html = templateEngine.process(templateName, context);

        try (ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {
            ITextRenderer renderer = new ITextRenderer();
            renderer.setDocumentFromString(html);
            renderer.layout();
            renderer.createPDF(outputStream);
            return outputStream.toByteArray();
        } catch (Exception e) {
            throw new IllegalStateException("Error generating PDF report", e);
        }
    }
}
