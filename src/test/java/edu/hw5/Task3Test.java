package edu.hw5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.util.Optional;
import static edu.hw5.Task3.Task3.parseDate;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task3Test {
    @Test
    @DisplayName("Проверка формата yyyy-MM-dd")
    public void format1ParseTest() {
        Optional<LocalDate> expected = Optional.of(LocalDate.of(2020, 10, 10));

        assertEquals(expected, parseDate("2020-10-10"));

        expected = Optional.of(LocalDate.of(2020, 12, 2));

        assertEquals(expected, parseDate("2020-12-2"));
    }

    @Test
    @DisplayName("Проверка формата dd/MM/yyyy")
    public void format2ParseTest() {
        Optional<LocalDate> expected = Optional.of(LocalDate.of(1976, 3, 1));

        assertEquals(expected, parseDate("1/3/1976"));

        expected = Optional.of(LocalDate.of(2020, 3, 1));

        assertEquals(expected, parseDate("1/3/20"));
    }

    @Test
    @DisplayName("Проверка относительной даты (словесно)")
    public void format3ParseTest() {
        Optional<LocalDate> expected = Optional.of(LocalDate.now().plusDays(1));

        assertEquals(expected, parseDate("tomorrow"));

        expected = Optional.of(LocalDate.now());

        assertEquals(expected, parseDate("today"));

        expected = Optional.of(LocalDate.now().minusDays(1));

        assertEquals(expected, parseDate("yesterday"));
    }

    @Test
    @DisplayName("Проверка относительной даты (численно)")
    public void format4ParseTest() {
        Optional<LocalDate> expected = Optional.of(LocalDate.now().minusDays(1));

        assertEquals(expected, parseDate("1 day ago"));

        expected = Optional.of(LocalDate.now().minusDays(2234));

        assertEquals(expected, parseDate("2234 days ago"));

        expected = Optional.of(LocalDate.now().plusDays(100));

        assertEquals(expected, parseDate("100 days later"));
    }

    @Test
    @DisplayName("Проверка на неправильный формат данных")
    public void invalidFormatTest() {
        Optional<LocalDate> expected = Optional.empty();

        assertEquals(expected, parseDate("20020-10-10"));
        assertEquals(expected, parseDate("2000 10 10"));
        assertEquals(expected, parseDate("1/300/1976"));
        assertEquals(expected, parseDate("1//3/1976"));
        assertEquals(expected, parseDate("NotToday"));
        assertEquals(expected, parseDate("Two days ago"));
        assertEquals(expected, parseDate("One day later"));
        assertEquals(expected, parseDate(""));
    }

    @Test
    @DisplayName("Проверка на null")
    public void nullTest() {
        Optional<LocalDate> expected = Optional.empty();

        assertEquals(expected, parseDate(null));
    }
}
