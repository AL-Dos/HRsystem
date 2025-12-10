package com.hrs.backend.Pdf.PdfUtil;

import java.time.LocalDate;

public class RefNumber {
    private static final String PREFIX = "RSSO11";

    // sequence must persist for the application's lifetime
    private int currentSequence = 0;
    private int lastYear = -1;

    public synchronized String buildRefNumber() {
        LocalDate today = LocalDate.now();

        int yearTwoDigits = today.getYear() % 100;
        String day = String.format("%02d", today.getDayOfMonth());
        String month = String.format("%02d", today.getMonthValue());

        if (lastYear != yearTwoDigits) {  // reset counter yearly
            currentSequence = 0;
            lastYear = yearTwoDigits;
        }

        currentSequence++;
        String seq = String.format("%04d", currentSequence);
        return yearTwoDigits + PREFIX + "-" + day + "-" + month + "-" + seq;

    }
}
