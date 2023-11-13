package edu.hw5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static edu.hw5.Task8.*;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Task8Test {
    @Test
    @DisplayName("Строка нечетной длины")
    public void regex1Test() {
        assertTrue(checkRegex1("101"));
        assertTrue(checkRegex1("1001110"));
        assertTrue(checkRegex1("1"));
        assertTrue(checkRegex1("0"));

        assertFalse(checkRegex1(""));
        assertFalse(checkRegex1("1234"));
        assertFalse(checkRegex1("rtcfnmew"));
        assertFalse(checkRegex1("1010"));
        assertFalse(checkRegex1("00"));
    }

    @Test
    @DisplayName("Начинается с 0 и имеет нечетную длину, или начинается с 1 и имеет четную длину")
    public void regex2Test() {
        assertTrue(checkRegex2("100110"));
        assertTrue(checkRegex2("1010"));
        assertTrue(checkRegex2("11"));
        assertTrue(checkRegex2("0"));
        assertTrue(checkRegex2("0110010"));
        assertTrue(checkRegex2("000"));

        assertFalse(checkRegex2(""));
        assertFalse(checkRegex2("101"));
        assertFalse(checkRegex2("10001"));
        assertFalse(checkRegex2("00"));
        assertFalse(checkRegex2("00101110"));
        assertFalse(checkRegex2("16156"));
        assertFalse(checkRegex2("awftgfyj"));
    }

    @Test
    @DisplayName("Любая строка, кроме 11 или 111")
    public void regex4Test() {
        assertTrue(checkRegex4("111101100"));
        assertTrue(checkRegex4("0001010"));
        assertTrue(checkRegex4("0"));
        assertTrue(checkRegex4("1"));
        assertTrue(checkRegex4(""));

        assertFalse(checkRegex4("11"));
        assertFalse(checkRegex4("111"));
        assertFalse(checkRegex2("16156"));
        assertFalse(checkRegex2("awftgfyj"));
    }

    @Test
    @DisplayName("Каждый нечетный символ равен 1")
    public void regex5Test() {
        assertTrue(checkRegex5("1"));
        assertTrue(checkRegex5("1111111"));
        assertTrue(checkRegex5("10101010"));

        assertFalse(checkRegex5("01110"));
        assertFalse(checkRegex5("1010100"));
        assertFalse(checkRegex5("0"));
        assertFalse(checkRegex5(""));
        assertFalse(checkRegex5("awfdbnsdo"));
        assertFalse(checkRegex5("@&%("));
        assertFalse(checkRegex5("1464awd"));
    }

    @Test
    @DisplayName("Нет последовательных 1")
    public void regex7Test() {
        assertTrue(checkRegex7(""));
        assertTrue(checkRegex7("10101000001"));
        assertTrue(checkRegex7("101"));
        assertTrue(checkRegex7("00000"));

        assertFalse(checkRegex7("110001010"));
        assertFalse(checkRegex7("010101011111"));
    }

    @Test
    @DisplayName("Проверка на null")
    public void nullTest() {
        assertFalse(checkRegex1(null));
        assertFalse(checkRegex2(null));
        assertFalse(checkRegex4(null));
        assertFalse(checkRegex5(null));
        assertFalse(checkRegex7(null));
    }
}
