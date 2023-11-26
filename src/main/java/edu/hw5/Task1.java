package edu.hw5;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

public class Task1 {
    private static final int MINS_IN_HOUR = 60;

    private Task1() {

    }

    public static String getAverageDuration(List<String> stringsList) {
        if (stringsList == null) {
            return null;
        }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd, HH:mm");

        List<String> sessions = stringsList.stream().filter(session -> session.matches(
                "^\\d{4}-\\d{2}-\\d{2}, \\d{2}:\\d{2} - \\d{4}-\\d{2}-\\d{2}, \\d{2}:\\d{2}$"
            ))
            .collect(Collectors.toList());

        if (sessions.isEmpty()) {
            return "0ч 0м";
        }

        long duration = sessions.stream()
            .map(session -> session.split(" - "))
            .map(timeBorders -> new LocalDateTime[] {
                LocalDateTime.parse(timeBorders[0], formatter),
                LocalDateTime.parse(timeBorders[1], formatter)
            })
            .map(timeBorders -> Duration.between(timeBorders[0], timeBorders[1]))
            .reduce(Duration.ZERO, Duration::plus)
            .dividedBy(sessions.size()).toMinutes();

        return String.format("%dч %dм", duration / MINS_IN_HOUR, duration % MINS_IN_HOUR);
    }
}
