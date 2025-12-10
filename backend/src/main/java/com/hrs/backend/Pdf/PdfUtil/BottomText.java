package com.hrs.backend.Pdf.PdfUtil;

import org.openpdf.text.Chunk;
import org.openpdf.text.Document;
import org.openpdf.text.DocumentException;
import org.openpdf.text.Element;
import org.openpdf.text.Font;
import org.openpdf.text.Paragraph;
import org.openpdf.text.Rectangle;
import org.openpdf.text.pdf.PdfPCell;
import org.openpdf.text.pdf.PdfPTable;

import com.hrs.backend.Services.DateFormatService;

public class BottomText {
        public void buildTop(Document doc, String name, DateFormatService service) throws DocumentException {
        PdfPTable area = new PdfPTable(1);
        area.setWidthPercentage(100);
        String date = service.getDate();

        Font boldFont = Fonts.getSigBold();
        Font smallFont = Fonts.getSigFont();

        Paragraph signHere = new Paragraph();
        signHere.add(new Chunk("This certification is issued upon the request of Mx." + name + " for employment and filing purposes", smallFont));
        signHere.add(new Chunk("\n\nDone this " + date + " at the City of Tagum, Davao del Norte, Philippines", smallFont));
        signHere.add(new Chunk("\n\n\n\nMICHELLE O. MANINGO\n", boldFont));
        signHere.add(new Chunk("(Supervising Statistical Specialist)\n", smallFont));
        signHere.add(new Chunk("Officer-in-Charge", smallFont));
        PdfPCell cell = new PdfPCell(signHere);

        cell.setBorder(Rectangle.NO_BORDER);
        cell.setHorizontalAlignment(Element.ALIGN_LEFT);
        
        area.addCell(cell);
        area.setSpacingAfter(2f);

        doc.add(area);
    }
}
