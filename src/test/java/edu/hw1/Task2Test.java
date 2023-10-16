package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static edu.hw1.Task2.countDigits;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task2Test {
    @Test
    @DisplayName("Проверка на правильность работы алгоритма")
    public void testCorrect() {
        //Входные данные: 123
        //Ожидаемый результат: 3
        //Пояснение: Число 123 состоит из 3 цифр
        int actual = countDigits(123);
        int expected = 3;
        assertEquals(expected, actual);

        //Входные данные: 177563
        //Ожидаемый результат: 6
        //Пояснение: Число 177563 состоит из 6 цифр
        actual = countDigits(177563);
        expected = 6;
        assertEquals(expected, actual);

        //Входные данные: -74301
        //Ожидаемый результат: 5
        //Пояснение: Число -74301 состоит из 5 цифр
        actual = countDigits(-74301);
        expected = 5;
        assertEquals(expected, actual);

        //Входные данные: 0
        //Ожидаемый результат: 1
        //Пояснение: Число 0 состоит из 1 цифры
        actual = countDigits(0);
        expected = 1;
        assertEquals(expected, actual);
    }

}
