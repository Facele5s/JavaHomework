package edu.hw5.Task3;

import java.time.LocalDate;

public class DateParser4 implements DateParser {
    public LocalDate parseDate(String str) {
        LocalDate date = LocalDate.now();

        String[] params = str.split(" ");
        int daysCount = Integer.parseInt(params[0]);

        return switch (params[2]) {
            case "ago" -> date.minusDays(daysCount);
            case "later" -> date.plusDays(daysCount);
            default -> null;
        };
    }
}
