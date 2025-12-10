package com.hrs.backend.Pdf.PdfUtil;

import org.openpdf.text.Chunk;
import org.openpdf.text.Document;
import org.openpdf.text.DocumentException;
import org.openpdf.text.Element;
import org.openpdf.text.Font;
import org.openpdf.text.Paragraph;

import com.hrs.backend.Models.PersonalInfo.PersonalInfo;

public class ServiceTopText {
    public void buildSignature(Document doc, PersonalInfo id) throws DocumentException {
        Font boldFont = Fonts.getSigBold();
        Font smallFont = Fonts.getSigFont();
        
        // name
        String first = id.getFirstName();
        String mid = id.getMiddleName().substring(0, 1);
        String last = id.getSurname();

        // Title
        Chunk title = new Chunk("CERTIFICATE OF EMPLOYMENT AND COMPENSATION", boldFont);
        title.setUnderline(1f, -2f);
        Paragraph titleLined = new Paragraph();
        titleLined.add(title);
        titleLined.setAlignment(Element.ALIGN_CENTER);
        titleLined.setSpacingAfter(20f);
        doc.add(titleLined);

        // Body Text
        Paragraph greetings = new Paragraph("TO WHOM IT MAY CONCERN: \n\n", smallFont);
        Paragraph para1 = new Paragraph("This is to certify that MX. ", smallFont);
        Paragraph paraBold = new Paragraph(first + " " + mid + ". " + last, boldFont);
        Paragraph para2 = new Paragraph(", has been hired as Contract of Service Worker by the Philippine Statistical Authority, Provincial Statistical Office-Davao del Norte\n\n", smallFont);
        Paragraph para3 = new Paragraph("This activity, designation, and duration that that Mx. " + last + " served in the office are stated below, to wit:", smallFont);

        greetings.setAlignment(Element.ALIGN_LEFT);
        paraBold.setAlignment(Element.ALIGN_JUSTIFIED);
        para1.setAlignment(Element.ALIGN_JUSTIFIED);
        para2.setAlignment(Element.ALIGN_JUSTIFIED);
        para3.setAlignment(Element.ALIGN_JUSTIFIED);

        doc.add(greetings);
        doc.add(paraBold);
        doc.add(para1);
        doc.add(para2);
        doc.add(para3);
    }
}
