package edu.hw5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.util.List;
import static edu.hw5.Task2.getAllFridays13;
import static edu.hw5.Task2.getNextFriday13;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class Task2Test {
    @Test
    @DisplayName("Поиск всех пятниц 13 за 1 год")
    public void fridays13Test() {
        List<LocalDate> fridays = List.of(
            LocalDate.of(1990, 4, 13),
            LocalDate.of(1990, 7, 13)
        );

        assertEquals(fridays, getAllFridays13(1990));

        fridays = List.of(
            LocalDate.of(2003, 6, 13)
        );

        assertEquals(fridays, getAllFridays13(2003));

        fridays = List.of(
            LocalDate.of(1981, 2, 13),
            LocalDate.of(1981, 3, 13),
            LocalDate.of(1981, 11, 13)
        );

        assertEquals(fridays, getAllFridays13(1981));
    }

    @Test
    @DisplayName("Поиск следующей пятницы 13")
    public void nextFriday13Test() {
        LocalDate date = LocalDate.of(2023, 11, 13);
        LocalDate next = LocalDate.of(2024, 9, 13);
        assertEquals(getNextFriday13(date), next);

        date = LocalDate.of(2011, 5, 13);
        next = LocalDate.of(2012, 1, 13);
        assertEquals(getNextFriday13(date), next);
    }

    @Test
    @DisplayName("Проверка на некорректность года")
    public void invalidYearTest() {
        assertThat(getAllFridays13(-1)).isEmpty();

        assertThat(getAllFridays13(0)).isEmpty();
    }

    @Test
    @DisplayName("Проверка на null")
    public void nullTest() {
        assertNull(getNextFriday13(null));
    }
}
