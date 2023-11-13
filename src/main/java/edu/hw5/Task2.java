package edu.hw5;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class Task2 {
    private Task2() {

    }

    @SuppressWarnings("MagicNumber")
    public static List<LocalDate> getAllFridays13(int year) {
        List<LocalDate> response = new ArrayList<>();

        for (int i = 1; i <= Month.values().length; i++) {
            LocalDate day = LocalDate.of(year, i, 13);

            if (day.getDayOfWeek().equals(DayOfWeek.FRIDAY)) {
                response.add(day);
            }
        }

        return response;
    }

    public static LocalDate getNearestFriday13(LocalDate date) {
        return date;
    }
}
