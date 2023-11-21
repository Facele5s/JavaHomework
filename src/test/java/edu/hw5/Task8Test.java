package edu.hw5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static edu.hw5.Task8.*;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Task8Test {
    @Test
    @DisplayName("Строка нечетной длины")
    public void oddLengthTest() {
        assertTrue(isOddLength("101"));
        assertTrue(isOddLength("1001110"));
        assertTrue(isOddLength("1"));
        assertTrue(isOddLength("0"));

        assertFalse(isOddLength(""));
        assertFalse(isOddLength("1234"));
        assertFalse(isOddLength("rtcfnmew"));
        assertFalse(isOddLength("1010"));
        assertFalse(isOddLength("00"));
    }

    @Test
    @DisplayName("Начинается с 0 и имеет нечетную длину, или начинается с 1 и имеет четную длину")
    public void zeroOddOrOneEvenTest() {
        assertTrue(zeroOddOrOneEven("100110"));
        assertTrue(zeroOddOrOneEven("1010"));
        assertTrue(zeroOddOrOneEven("11"));
        assertTrue(zeroOddOrOneEven("0"));
        assertTrue(zeroOddOrOneEven("0110010"));
        assertTrue(zeroOddOrOneEven("000"));

        assertFalse(zeroOddOrOneEven(""));
        assertFalse(zeroOddOrOneEven("101"));
        assertFalse(zeroOddOrOneEven("10001"));
        assertFalse(zeroOddOrOneEven("00"));
        assertFalse(zeroOddOrOneEven("00101110"));
        assertFalse(zeroOddOrOneEven("16156"));
        assertFalse(zeroOddOrOneEven("awftgfyj"));
    }

    @Test
    @DisplayName("Любая строка, кроме 11 или 111")
    public void not11or111Test() {
        assertTrue(not11or111("111101100"));
        assertTrue(not11or111("0001010"));
        assertTrue(not11or111("0"));
        assertTrue(not11or111("1"));
        assertTrue(not11or111(""));

        assertFalse(not11or111("11"));
        assertFalse(not11or111("111"));
        assertFalse(not11or111("16156"));
        assertFalse(not11or111("awftgfyj"));
    }

    @Test
    @DisplayName("Каждый нечетный символ равен 1")
    public void everyOddChar1Check() {
        assertTrue(isEveryOddChar1("1"));
        assertTrue(isEveryOddChar1("1111111"));
        assertTrue(isEveryOddChar1("10101010"));

        assertFalse(isEveryOddChar1("01110"));
        assertFalse(isEveryOddChar1("1010100"));
        assertFalse(isEveryOddChar1("0"));
        assertFalse(isEveryOddChar1(""));
        assertFalse(isEveryOddChar1("awfdbnsdo"));
        assertFalse(isEveryOddChar1("@&%("));
        assertFalse(isEveryOddChar1("1464awd"));
    }

    @Test
    @DisplayName("Нет последовательных 1")
    public void noSequentialOnesTest() {
        assertTrue(noSequentialOnes(""));
        assertTrue(noSequentialOnes("10101000001"));
        assertTrue(noSequentialOnes("101"));
        assertTrue(noSequentialOnes("00000"));

        assertFalse(noSequentialOnes("110001010"));
        assertFalse(noSequentialOnes("010101011111"));
    }

    @Test
    @DisplayName("Проверка на null")
    public void nullTest() {
        assertFalse(isOddLength(null));
        assertFalse(zeroOddOrOneEven(null));
        assertFalse(not11or111(null));
        assertFalse(isEveryOddChar1(null));
        assertFalse(noSequentialOnes(null));
    }
}
