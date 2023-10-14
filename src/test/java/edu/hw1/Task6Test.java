package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static edu.hw1.Task6.countK;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task6Test {
    @Test
    @DisplayName("Правильность результата")
    public void testCorrect() {
        int actual = countK(3524);
        int expected = 3;
        assertEquals(expected, actual);

        actual = countK(6621);
        expected = 5;
        assertEquals(expected, actual);

        actual = countK(6554);
        expected = 4;
        assertEquals(expected, actual);

        actual = countK(1234);
        expected = 3;
        assertEquals(expected, actual);

        actual = countK(6174);
        expected = 0;
        assertEquals(expected, actual);

        actual = countK(1001);
        expected = 4;
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Фильтрация чисел меньше 1000")
    public void testSmallNumbers() {
        int actual = countK(999);
        int expected = -1;
        assertEquals(expected, actual);

        actual = countK(0);
        assertEquals(expected, actual);

        actual = countK(-87);
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Фильтрация чисел больше 9999")
    public void testBigNumbers() {
        int actual = countK(10348);
        int expected = -1;
        assertEquals(expected, actual);

        actual = countK(249129712);
        assertEquals(expected, actual);

        actual = countK(10000);
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Фильтрация чисел с одинаковыми цифрами")
    public void testEqualDigits() {
        int actual = countK(1111);
        int expected = -1;
        assertEquals(expected, actual);

        actual = countK(3333);
        assertEquals(expected, actual);

        actual = countK(9999);
        assertEquals(expected, actual);
    }

}
