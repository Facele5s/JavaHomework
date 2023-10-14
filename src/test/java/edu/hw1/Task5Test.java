package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static edu.hw1.Task5.isPalindromeDescendant;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task5Test {
    @Test
    @DisplayName("Правильность результата")
    public void testCorrect() {
        boolean actual = isPalindromeDescendant(11211230);  //True
        boolean expected = true;
        assertEquals(expected, actual);

        actual = isPalindromeDescendant(13001120);  //True
        assertEquals(expected, actual);

        actual = isPalindromeDescendant(23336014);  //True
        assertEquals(expected, actual);

        actual = isPalindromeDescendant(11);    //True
        assertEquals(expected, actual);

        actual = isPalindromeDescendant(5858);  //True
        assertEquals(expected, actual);

        actual = isPalindromeDescendant(0); //True
        assertEquals(expected, actual);

        actual = isPalindromeDescendant(9); //True
        assertEquals(expected, actual);

        actual = isPalindromeDescendant(123);   //True
        assertEquals(expected, actual);

        actual = isPalindromeDescendant(8583);  //False
        expected = false;
        assertEquals(expected, actual);

        actual = isPalindromeDescendant(12);    //False
        assertEquals(expected, actual);

        actual = isPalindromeDescendant(456);   //False
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Проверка на отрицательном числе")
    public void testNegative() {
        boolean actual = isPalindromeDescendant(-11211230);
        boolean expected = true;
        assertEquals(expected, actual);

        actual = isPalindromeDescendant(-8583);
        expected = false;
        assertEquals(expected, actual);
    }

}
