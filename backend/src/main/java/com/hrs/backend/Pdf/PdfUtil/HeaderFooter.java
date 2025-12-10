package com.hrs.backend.Pdf.PdfUtil;

import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

import org.openpdf.text.BadElementException;
import org.openpdf.text.Document;
import org.openpdf.text.DocumentException;
import org.openpdf.text.Image;
import org.openpdf.text.pdf.PdfContentByte;
import org.openpdf.text.pdf.PdfPageEventHelper;
import org.openpdf.text.pdf.PdfWriter;

public class HeaderFooter extends PdfPageEventHelper{
    private Image header;
    private Image footer;
    private static final int IMAGE_WIDTH = 390;
    private static final int HEADER_HEIGHT = 70;
    private static final int FOOTER_HEIGHT = 70;

    @Override
        public void onOpenDocument(PdfWriter writer, Document document) {
        try {
            header = loadImage("/templates/Header.png");
            footer = loadImage("/templates/Footer.png");

            if (header != null) {
                header.scaleAbsolute(IMAGE_WIDTH + 100, HEADER_HEIGHT);
            }
            if (footer != null) {
                footer.scaleAbsolute(IMAGE_WIDTH, FOOTER_HEIGHT);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onEndPage(PdfWriter writer, Document document) {
        PdfContentByte content = writer.getDirectContent();

        try {
            if (header != null) {
                header.setAbsolutePosition(document.left() + 25, document.top() + 10);
                content.addImage(header);
            }

            if (footer != null) {
                footer.setAbsolutePosition(document.left() + 25, document.bottom() - 60);
                content.addImage(footer);
            }
        } catch (DocumentException error) {
            error.printStackTrace();
        }
    }

    private Image loadImage(String path) throws IOException, BadElementException {
        try (InputStream input = getClass().getResourceAsStream(path)) {
            if (input == null) {
                System.err.println("Could not load the image properly: " + path);
                return null;
            }
            return Image.getInstance(ImageIO.read(input), null);
        }
    }
}
