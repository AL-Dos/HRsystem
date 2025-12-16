package com.hrs.backend.Pdf.ServiceRendered;

import java.awt.Color;
import java.util.List;

import org.openpdf.text.Document;
import org.openpdf.text.DocumentException;
import org.openpdf.text.Element;
import org.openpdf.text.Font;
import org.openpdf.text.Phrase;
import org.openpdf.text.pdf.PdfPCell;
import org.openpdf.text.pdf.PdfPTable;

import com.hrs.backend.DTOs.ServiceRow;
import com.hrs.backend.Pdf.PdfUtil.Fonts;

public class TableBuilder {
    public void build(Document doc, List<ServiceRow> rows) throws DocumentException {
        PdfPTable table = new PdfPTable(4);
        table.setWidthPercentage(100);
        table.setSpacingBefore(20f);
        table.setWidths(new float[]{1.2f, 3f, 2.5f, 3f});

        Font headerFont = Fonts.getSigBold();
        Font bodyFont = Fonts.getSigFont();
        Font boldFont = Fonts.getSigBold();

        // ---- HEADER ROW ----
        addHeaderCell(table, "No.", headerFont);
        addHeaderCell(table, "Activity", headerFont);
        addHeaderCell(table, "Designation", headerFont);
        addHeaderCell(table, "Duration", headerFont);
        table.setHeaderRows(1);

        // ---- BODY ROWS ----
        int counter = 1;
        if (rows == null || rows.isEmpty()) {
            PdfPCell empty = new PdfPCell(new Phrase("No employment records provided.", bodyFont));
            empty.setColspan(4);
            empty.setPadding(10f);
            empty.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(empty);
        } 
        else {
            for (ServiceRow r : rows) {
                boolean isPresent = r.getDuration() != null && r.getDuration().toLowerCase().contains("present");
                Font rowFont = isPresent ? boldFont : bodyFont; 
                addBodyCell(table, String.valueOf(counter++), bodyFont, Element.ALIGN_CENTER);
                addBodyCell(table, safe(r.getActivity()), bodyFont, Element.ALIGN_LEFT);
                addBodyCell(table, safe(r.getDesignation()), bodyFont, Element.ALIGN_LEFT);
                addBodyCell(table, safe(r.getDuration()), rowFont, Element.ALIGN_LEFT);
            }
        }
        doc.add(table);
    }

    private void addHeaderCell(PdfPTable table, String text, Font font) {
        PdfPCell cell = new PdfPCell(new Phrase(text, font));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        cell.setPadding(6f);
        cell.setBackgroundColor(new Color(230, 230, 230));
        table.addCell(cell);
    }

    private void addBodyCell(PdfPTable table, String text, Font font, int align) {
        PdfPCell cell = new PdfPCell(new Phrase(text, font));
        cell.setPadding(6f);
        cell.setHorizontalAlignment(align);
        cell.setHorizontalAlignment(Element.ALIGN_MIDDLE);
        cell.setMinimumHeight(22f);
        cell.setBorderWidth(0.8f);
        table.addCell(cell);
    }

    private String safe(String value) {
        return value == null ? "" : value;
    }
}
