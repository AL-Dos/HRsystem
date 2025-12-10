package com.hrs.backend.Pdf.PdfUtil;

import org.openpdf.text.Font;
import org.openpdf.text.FontFactory;

public class Fonts {
    private Fonts() {}
    public static Font getRefFont() {
        return FontFactory.getFont(FontFactory.HELVETICA, 10);
    }

    public static Font getSigFont() {
        return FontFactory.getFont(FontFactory.HELVETICA, 12);
    }

    public static Font getSigBold() {
        return FontFactory.getFont(FontFactory.HELVETICA, 12, Font.BOLD);
    }
}
