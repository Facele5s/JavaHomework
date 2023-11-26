package edu.hw5.Task3;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateParser1 implements DateParser {
    public LocalDate parseDate(String str) {
        String pattern = buildPattern(str);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);

        return LocalDate.parse(str, formatter);
    }

    private String buildPattern(String str) {
        StringBuilder pattern = new StringBuilder();
        String[] params = str.split("-");

        pattern.append("y".repeat(params[0].length()));
        pattern.append("-");
        pattern.append("M".repeat(params[1].length()));
        pattern.append("-");
        pattern.append("d".repeat(params[2].length()));

        return pattern.toString();
    }
}
