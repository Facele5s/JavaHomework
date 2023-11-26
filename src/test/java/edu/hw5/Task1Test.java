package edu.hw5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.Collections;
import java.util.List;
import static edu.hw5.Task1.getAverageDuration;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class Task1Test {
    @Test
    @DisplayName("Проверка подсчёта средней продолжительности")
    public void averageDurationTest() throws Exception {
        List<String> sessions = List.of(
            "2022-03-12, 20:20 - 2022-03-12, 23:50",
            "2022-04-01, 21:30 - 2022-04-02, 01:20"
        );

        assertEquals(getAverageDuration(sessions), "3ч 40м");

        sessions = List.of(
            "2023-05-17, 00:01 - 2023-05-17, 04:24",
            "2022-01-12, 19:45 - 2022-01-13, 00:43",
            "2020-11-10, 08:56 - 2020-11-12, 17:25",
            "2019-12-31, 07:00 - 2019-12-31, 07:05"
        );

        assertEquals(getAverageDuration(sessions), "16ч 28м");

        sessions = List.of(
            "2023-05-17, 00:01 - 2023-05-17, 04:24"
        );

        assertEquals(getAverageDuration(sessions), "4ч 23м");
    }

    @Test
    @DisplayName("Проверка на некорректно введённую дату")
    public void incorrectInputTest() {
        List<String> sessions = List.of(
            "2022-03awd-12, 20:20 - 2022-03greawq-12, 23:50",
            "2022-04-01, 21:302022-04-02, 01:20",
            "20-04-01, 21:30 - 2022-04-02, 01:20"
        );

        assertEquals(getAverageDuration(sessions), "0ч 0м");
    }

    @Test
    @DisplayName("Проверка на пустой список")
    public void emptyListTest() {
        List<String> sessions = Collections.emptyList();

        assertEquals(getAverageDuration(sessions), "0ч 0м");
    }

    @Test
    @DisplayName("Проверка на null")
    public void nullTest() {
        List<String> sessions = null;

        assertNull(getAverageDuration(sessions));
    }
}
