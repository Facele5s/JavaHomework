package edu.hw5.Task3;

import java.time.LocalDate;

public class DateParser3 implements DateParser {
    public LocalDate parseDate(String str) {
        LocalDate date = LocalDate.now();

        return switch (str.toUpperCase()) {
            case "YESTERDAY" -> date.minusDays(1);
            case "TODAY" -> date;
            case "TOMORROW" -> date.plusDays(1);
            default -> null;
        };
    }
}
