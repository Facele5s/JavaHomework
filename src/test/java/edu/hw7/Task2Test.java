package edu.hw7;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static edu.hw7.Task2.factorialParallel;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

public class Task2Test {
    @Test
    @DisplayName("Проверка вычисления факториала")
    public void factorialTest() {
        assertEquals(factorialParallel(5), 120);

        assertEquals(factorialParallel(1), 1);

        assertEquals(factorialParallel(10), 3628800);
    }

    @Test
    @DisplayName("Вычисление факториала нуля")
    public void zeroFactorialTest() {
        assertEquals(factorialParallel(0), 1);
    }

    @Test
    @DisplayName("Проверка фильтрации отрицательных чисел")
    public void negativeFilterTest() {
        try {
            factorialParallel(-1);
        } catch (IllegalArgumentException e) {
            assertTrue(true);
            return;
        }

        fail();
    }

}
