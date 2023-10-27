package edu.hw3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static edu.hw3.Task4.convertToRoman;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task4Test {
    @Test
    @DisplayName("Фильтрация отрицательных чисел")
    public void negativeNumbersTest() {
        assertEquals("", convertToRoman(-1));

        assertEquals("", convertToRoman(-10));

        assertEquals("", convertToRoman(-100500));
    }

    @Test
    @DisplayName("Проверка на ноль")
    public void zeroTest() {
        assertEquals("N", convertToRoman(0));
    }

    @Test
    @DisplayName("Проверка правильности конвертации")
    public void convertToRomanTest() {
        assertEquals("I", convertToRoman(1));

        assertEquals("III", convertToRoman(3));

        assertEquals("XVI", convertToRoman(16));

        assertEquals("MMMCMXCIX", convertToRoman(3999));

        assertEquals("C", convertToRoman(100));

        assertEquals("MCMXCIX", convertToRoman(1999));
    }
}
