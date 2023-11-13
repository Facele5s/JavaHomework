package edu.hw5.Task3;

import java.time.LocalDate;
import java.util.Optional;

public class Task3 {
    public Optional<LocalDate> parseDate(String str) {
        DateParser parser = getDatePatternType(str);

        LocalDate date = parser.parseDate(str);

        return date != null ? Optional.of(date) : Optional.empty();
    }

    private static DateParser getDatePatternType(String str) {
        DateParser dateParser = null;

        if (str.matches("^\\d{1,4}-\\d{1,2}-\\d{1,2}$")) {
            dateParser = new DateParser1();
        }
        if (str.matches("^\\d{1,2}/\\d{1,2}/\\d{1,4}$")) {
            dateParser = new DateParser2();
        }
        if (str.equalsIgnoreCase("yesterday")
            || str.equalsIgnoreCase("today")
            || str.equalsIgnoreCase("tomorrow")) {
            dateParser = new DateParser3();
        }
        if (str.toLowerCase().matches("^\\d+ day(s)* (ago|later)$")) {
            dateParser = new DateParser4();
        }

        return dateParser;
    }
}
