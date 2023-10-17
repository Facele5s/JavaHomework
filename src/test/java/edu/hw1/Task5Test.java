package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static edu.hw1.Task5.isPalindromeDescendant;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Task5Test {
    @Test
    @DisplayName("Проверка правильности работы алгоритма")
    public void testCorrect() {
        //Входные данные: 11211230
        //Ожидаемый результат: True
        //Пояснение: Один из потомков числа является палиндромом
        assertTrue(isPalindromeDescendant(11211230));

        //Входные данные: 13001120
        //Ожидаемый результат: True
        //Пояснение: Один из потомков числа является палиндромом
        assertTrue(isPalindromeDescendant(13001120));

        //Входные данные: 23336014
        //Ожидаемый результат: True
        //Пояснение: Один из потомков числа является палиндромом
        assertTrue(isPalindromeDescendant(23336014));

        //Входные данные: 11
        //Ожидаемый результат: True
        //Пояснение: Число является палиндромом
        assertTrue(isPalindromeDescendant(11));

        //Входные данные: 5858
        //Ожидаемый результат: True
        //Пояснение: Один из потомков числа является палиндромом
        assertTrue(isPalindromeDescendant(5858));

        //Входные данные: 0
        //Ожидаемый результат: True
        //Пояснение: Число является палиндромом
        assertTrue(isPalindromeDescendant(0));

        //Входные данные: 9
        //Ожидаемый результат: True
        //Пояснение: Число является палиндромом
        assertTrue(isPalindromeDescendant(9));

        //Входные данные: 123
        //Ожидаемый результат: True
        //Пояснение: Один из потомков числа является палиндромом
        assertTrue(isPalindromeDescendant(123));

        //Входные данные: 8583
        //Ожидаемый результат: False
        //Пояснение: Число не является палиндромом и не имеет таких потомков
        assertFalse(isPalindromeDescendant(8583));

        //Входные данные: 12
        //Ожидаемый результат: False
        //Пояснение: Число не является палиндромом и не имеет таких потомков
        assertFalse(isPalindromeDescendant(12));

        //Входные данные: 456
        //Ожидаемый результат: False
        //Пояснение: Число не является палиндромом и не имеет таких потомков
        assertFalse(isPalindromeDescendant(456));
    }

    @Test
    @DisplayName("Проверка алгоритма на отрицательном числе")
    public void testNegativeNumbers() {
        //Входные данные: -11211230
        //Ожидаемый результат: True
        //Пояснение: Один из потомков числа является палиндромом
        assertTrue(isPalindromeDescendant(-11211230));

        //Входные данные: -8583
        //Ожидаемый результат: False
        //Пояснение: Число не является палиндромом и не имеет таких потомков
        assertFalse(isPalindromeDescendant(-8583));
    }

}
