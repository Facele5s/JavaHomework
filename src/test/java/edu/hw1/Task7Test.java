package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static edu.hw1.Task7.rotate;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task7Test {
    @Test
    @DisplayName("Правильность результата")
    public void testCorrect() {
        int actual = rotate(8, 1);
        int expected = 4;
        assertEquals(expected, actual);

        actual = rotate(16, -1);
        expected = 1;
        assertEquals(expected, actual);

        actual = rotate(17, -2);
        expected = 6;
        assertEquals(expected, actual);

        actual = rotate(21, 10);
        expected = 21;
        assertEquals(expected, actual);

        actual = rotate(1, 100500);
        expected = 1;
        assertEquals(expected, actual);

        actual = rotate(16, 1);
        expected = 8;
        assertEquals(expected, actual);

        actual = rotate(16, 2);
        expected = 4;
        assertEquals(expected, actual);

        actual = rotate(16, 3);
        expected = 2;
        assertEquals(expected, actual);

        actual = rotate(16, 4);
        expected = 1;
        assertEquals(expected, actual);

        actual = rotate(16, 5);
        expected = 16;
        assertEquals(expected, actual);

        actual = rotate(108, 0);
        expected = 108;
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Фильтрация отрицательных значений")
    public void testNegative() {
        int actual = rotate(-1, 1);
        int expected = -1;
        assertEquals(expected, actual);

        actual = rotate(-18, 1);
        assertEquals(expected, actual);
    }

}
