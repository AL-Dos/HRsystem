package com.hrs.backend.Services;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Service;

@Service
public class DateFormatService {
    public String getDate() {
        LocalDate today = LocalDate.now();
        int day = today.getDayOfMonth();
        String daySuffix = day + getDaySuffix(day);

        DateTimeFormatter monthYearFormatter = DateTimeFormatter.ofPattern("MMMM yyyy");
        String monthYear = today.format(monthYearFormatter);

        return String.format("%s day of %sd", daySuffix, monthYear);
    }

    private String getDaySuffix(int day) {
        if (day >= 11 && day <= 13) { return "th"; }
        return switch(day % 10) {
            case 1 -> "st";
            case 2 -> "nd";
            case 3 -> "rd";
            default -> "th";
        };
    } 
}
