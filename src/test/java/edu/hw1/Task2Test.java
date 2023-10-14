package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static edu.hw1.Task2.countDigits;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task2Test {
    @Test
    @DisplayName("Правильность результата")
    public void testCorrect() {
        int actual = countDigits(123);
        int expected = 3;
        assertEquals(expected, actual);

        actual = countDigits(177563);
        expected = 6;
        assertEquals(expected, actual);

        actual = countDigits(-74301);
        expected = 5;
        assertEquals(expected, actual);

        actual = countDigits(0);
        expected = 1;
        assertEquals(expected, actual);
    }

}
