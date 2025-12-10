package com.hrs.backend.Pdf.Employment;

import java.io.ByteArrayOutputStream;

import org.openpdf.text.Document;
import org.openpdf.text.Element;
import org.openpdf.text.Font;
import org.openpdf.text.FontFactory;
import org.openpdf.text.PageSize;
import org.openpdf.text.Paragraph;
import org.openpdf.text.pdf.PdfWriter;

import com.hrs.backend.Models.PersonalInfo.PersonalInfo;
import com.hrs.backend.Pdf.PdfUtil.BottomText;
import com.hrs.backend.Pdf.PdfUtil.HeaderFooter;
import com.hrs.backend.Pdf.PdfUtil.RefNumber;
import com.hrs.backend.Pdf.PdfUtil.TopText;
import com.hrs.backend.Services.DateFormatService;

public class EmpCertPdfBuilder {
    private final RefNumber ref = new RefNumber();
    private final TopText top = new TopText();
    private final BottomText bot = new BottomText();

    public byte[] build(PersonalInfo info, DateFormatService dateService) throws Exception {
        Document doc = new Document(PageSize.LETTER, 50, 50, 90, 70);
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        PdfWriter writer = PdfWriter.getInstance(doc, out);
        writer.setPageEvent(new HeaderFooter());

        doc.open();

        // 1. REF NUMBER
        String refNum = ref.buildRefNumber();

        Font italic = FontFactory.getFont(FontFactory.HELVETICA_OBLIQUE, 10);
        Paragraph refPara = new Paragraph("Ref No: " + refNum + "\n\n", italic);
        refPara.setAlignment(Element.ALIGN_LEFT);
        doc.add(refPara);

        // 2. TOP TEXT
        top.buildSignature(doc, info);

        // 3. BOTTOM TEXT
        bot.buildTop(doc, info.getFirstName() + " " + info.getSurname(), dateService);

        doc.close();
        return out.toByteArray();
    }
}
