package edu.hw5;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Task1 {
    private static final int MINS_IN_HOUR = 60;

    private Task1() {

    }

    public static String getAverageDuration(List<String> sessions) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd, HH:mm");

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
