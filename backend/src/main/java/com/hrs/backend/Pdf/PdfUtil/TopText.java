package com.hrs.backend.Pdf.PdfUtil;

import org.openpdf.text.Chunk;
import org.openpdf.text.Document;
import org.openpdf.text.DocumentException;
import org.openpdf.text.Element;
import org.openpdf.text.Font;
import org.openpdf.text.Paragraph;

import com.hrs.backend.Models.PersonalInfo.PersonalInfo;

public class TopText {
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
        Paragraph paraBold = new Paragraph("THIS IS TO CERTIFY THAT MX. " + first + " " + mid + ". " + last, boldFont);
        Paragraph para1 = new Paragraph(" is a permanent emplpoyee of the Philippine Statistical Authority, Provincial Statistical Office-Davao del Norte\n\n", smallFont);
        Paragraph para2 = new Paragraph("This position, status, monthly compensation, and inclusive dates that Mx. " + last + " served in the office are stated below, to wit:");

        greetings.setAlignment(Element.ALIGN_LEFT);
        paraBold.setAlignment(Element.ALIGN_JUSTIFIED);
        para1.setAlignment(Element.ALIGN_JUSTIFIED);
        para2.setAlignment(Element.ALIGN_JUSTIFIED);

        doc.add(greetings);
        doc.add(paraBold);
        doc.add(para1);
        doc.add(para2);
    }
}
