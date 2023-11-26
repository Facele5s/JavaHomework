package edu.hw5;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Task2 {
    private Task2() {

    }

    @SuppressWarnings("MagicNumber")
    public static List<LocalDate> getAllFridays13(int year) {
        if (year <= 0) {
            return Collections.emptyList();
        }

        List<LocalDate> response = new ArrayList<>();

        for (int i = 1; i <= Month.values().length; i++) {
            LocalDate day = LocalDate.of(year, i, 13);

            if (day.getDayOfWeek().equals(DayOfWeek.FRIDAY)) {
                response.add(day);
            }
        }

        return response;
    }

    @SuppressWarnings("MagicNumber")
    public static LocalDate getNextFriday13(LocalDate date) {
        if (date == null) {
            return null;
        }

        LocalDate nextFriday13 = date.with(TemporalAdjusters.next(DayOfWeek.FRIDAY));

        while (nextFriday13.getDayOfMonth() != 13) {
            nextFriday13 = nextFriday13.with(TemporalAdjusters.next(DayOfWeek.FRIDAY));
        }

        return nextFriday13;
    }
}
