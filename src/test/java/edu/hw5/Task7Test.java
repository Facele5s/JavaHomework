package edu.hw5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static edu.hw5.Task7.*;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Task7Test {
    @Test
    @DisplayName("Содержит не менее 3 символов, причем третий символ равен 0")
    public void threeMoreCharsWithThirdZeroTest() {
        assertTrue(hasThreeMoreCharsWithThirdZero("000"));
        assertTrue(hasThreeMoreCharsWithThirdZero("110"));
        assertTrue(hasThreeMoreCharsWithThirdZero("1101100101"));

        assertFalse(hasThreeMoreCharsWithThirdZero("01"));
        assertFalse(hasThreeMoreCharsWithThirdZero("01110"));
        assertFalse(hasThreeMoreCharsWithThirdZero("a10110"));
        assertFalse(hasThreeMoreCharsWithThirdZero("2110110"));
        assertFalse(hasThreeMoreCharsWithThirdZero(""));
    }

    @Test
    @DisplayName("Начинается и заканчивается одним и тем же символом")
    public void sameStartEndCharTest() {
        assertTrue(hasSameStartEndChar("0100010"));
        assertTrue(hasSameStartEndChar("11011"));
        assertTrue(hasSameStartEndChar("1"));
        assertTrue(hasSameStartEndChar("11"));
        assertTrue(hasSameStartEndChar("00"));
        assertTrue(hasSameStartEndChar("0"));

        assertFalse(hasSameStartEndChar("0111101"));
        assertFalse(hasSameStartEndChar("01"));
        assertFalse(hasSameStartEndChar("10"));
        assertFalse(hasSameStartEndChar("015640"));
        assertFalse(hasSameStartEndChar("1jyt qw1"));
        assertFalse(hasSameStartEndChar(""));
    }

    @Test
    @DisplayName("Длина не менее 1 и не более 3")
    public void lengthBetweenOneThreeTest() {
        assertTrue(lengthBetweenOneThree("101"));
        assertTrue(lengthBetweenOneThree("01"));
        assertTrue(lengthBetweenOneThree("1"));
        assertTrue(lengthBetweenOneThree("010"));
        assertTrue(lengthBetweenOneThree("111"));

        assertFalse(lengthBetweenOneThree("110100011"));
        assertFalse(lengthBetweenOneThree("qwe"));
        assertFalse(lengthBetweenOneThree("12"));
        assertFalse(lengthBetweenOneThree(""));
    }

    @Test
    @DisplayName("Проверка на null")
    public void nullTest() {
        assertFalse(hasThreeMoreCharsWithThirdZero(null));
        assertFalse(hasSameStartEndChar(null));
        assertFalse(lengthBetweenOneThree(null));
    }
}
