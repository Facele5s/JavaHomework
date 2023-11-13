package edu.hw5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static edu.hw5.Task7.*;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Task7Test {
    @Test
    @DisplayName("Содержит не менее 3 символов, причем третий символ равен 0")
    public void regex1Test() {
        assertTrue(checkRegex1("000"));
        assertTrue(checkRegex1("110"));
        assertTrue(checkRegex1("1101100101"));

        assertFalse(checkRegex1("01"));
        assertFalse(checkRegex1("01110"));
        assertFalse(checkRegex1("a10110"));
        assertFalse(checkRegex1("2110110"));
        assertFalse(checkRegex1(""));
    }

    @Test
    @DisplayName("Начинается и заканчивается одним и тем же символом")
    public void regex2Test() {
        assertTrue(checkRegex2("0100010"));
        assertTrue(checkRegex2("11011"));
        assertTrue(checkRegex2("1"));
        assertTrue(checkRegex2("11"));
        assertTrue(checkRegex2("00"));
        assertTrue(checkRegex2("0"));

        assertFalse(checkRegex2("0111101"));
        assertFalse(checkRegex2("01"));
        assertFalse(checkRegex2("10"));
        assertFalse(checkRegex2("015640"));
        assertFalse(checkRegex2("1jyt qw1"));
        assertFalse(checkRegex2(""));
    }

    @Test
    @DisplayName("Длина не менее 1 и не более 3")
    public void regex3Test() {
        assertTrue(checkRegex3("101"));
        assertTrue(checkRegex3("01"));
        assertTrue(checkRegex3("1"));
        assertTrue(checkRegex3("010"));
        assertTrue(checkRegex3("111"));

        assertFalse(checkRegex3("110100011"));
        assertFalse(checkRegex3("qwe"));
        assertFalse(checkRegex3("12"));
        assertFalse(checkRegex3(""));
    }

    @Test
    @DisplayName("Проверка на null")
    public void nullTest() {
        assertFalse(checkRegex1(null));
        assertFalse(checkRegex2(null));
        assertFalse(checkRegex3(null));
    }
}
