package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static edu.hw1.Task1.minutesToSeconds;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task1Test {
    @Test
    @DisplayName("Строка содержит только цифры И двоеточие")
    public void testDigitsColon() {
        int actual = minutesToSeconds("");
        int expected = -1;
        assertEquals(expected, actual);

        actual = minutesToSeconds("1ab2");
        assertEquals(expected, actual);

        actual = minutesToSeconds(":");
        assertEquals(expected, actual);

        actual = minutesToSeconds(null);
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Строка содержит ОДНО двоеточие")
    public void testOneColon() {
        int actual = minutesToSeconds("12::34");
        int expected = -1;
        assertEquals(expected, actual);

        actual = minutesToSeconds("1:2:34");
        assertEquals(expected, actual);

        actual = minutesToSeconds("1::::16");
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Двоеточие находится в начале или в конце строки")
    public void testColonAtTheEdge() {
        int actual = minutesToSeconds(":1234");
        int expected = -1;
        assertEquals(expected, actual);

        actual = minutesToSeconds("1234:");
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Количество секунд не превышает 60")
    public void testSeconds() {
        int actual = minutesToSeconds("12:720");
        int expected = -1;
        assertEquals(expected, actual);

        actual = minutesToSeconds("52245:19190");
        assertEquals(expected, actual);

        actual = minutesToSeconds("10:60");
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Правильность результата")
    public void testCorrect() {
        int actual = minutesToSeconds("01:00");
        int expected = 60;
        assertEquals(expected, actual);

        actual = minutesToSeconds("13:56");
        expected = 836;
        assertEquals(expected, actual);

        actual = minutesToSeconds("1216:59");
        expected = 73019;
        assertEquals(expected, actual);
    }

}
