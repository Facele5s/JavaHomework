package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static edu.hw1.Task7.rotate;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task7Test {
    @Test
    @DisplayName("Проверка циклического битового сдвига")
    public void testCorrect() {
        //Входные данные: 8, 1
        //Ожидаемый результат: 4
        //Пояснение: 1000 (8) -> 0100 (4)
        int actual = rotate(8, 1);
        int expected = 4;
        assertEquals(expected, actual);

        //Входные данные: 16, -1
        //Ожидаемый результат: 1
        //Пояснение: 10000 (16) -> 00001 (1)
        actual = rotate(16, -1);
        expected = 1;
        assertEquals(expected, actual);

        //Входные данные: 17, -2
        //Ожидаемый результат: 6
        //Пояснение: 10001 (17) -> 00110 (6)
        actual = rotate(17, -2);
        expected = 6;
        assertEquals(expected, actual);

        //Входные данные: 21, 10
        //Ожидаемый результат: 21
        //Пояснение: 10101 (21) -> 10101 (21)
        actual = rotate(21, 10);
        expected = 21;
        assertEquals(expected, actual);

        //Входные данные: 1, 100500
        //Ожидаемый результат: 1
        //Пояснение: 1 (1) -> 1 (1)
        actual = rotate(1, 100500);
        expected = 1;
        assertEquals(expected, actual);

        //Входные данные: 16, 1
        //Ожидаемый результат: 8
        //Пояснение: 10000 (16) -> 01000 (8)
        actual = rotate(16, 1);
        expected = 8;
        assertEquals(expected, actual);

        //Входные данные: 16, 2
        //Ожидаемый результат: 4
        //Пояснение: 10000 (16) -> 00100 (4)
        actual = rotate(16, 2);
        expected = 4;
        assertEquals(expected, actual);

        //Входные данные: 16, 3
        //Ожидаемый результат: 2
        //Пояснение: 10000 (16) -> 00010 (2)
        actual = rotate(16, 3);
        expected = 2;
        assertEquals(expected, actual);

        //Входные данные: 16, 4
        //Ожидаемый результат: 1
        //Пояснение: 10000 (16) -> 00001 (1)
        actual = rotate(16, 4);
        expected = 1;
        assertEquals(expected, actual);

        //Входные данные: 16, 5
        //Ожидаемый результат: 16
        //Пояснение: 10000 (16) -> 10000 (16)
        actual = rotate(16, 5);
        expected = 16;
        assertEquals(expected, actual);

        //Входные данные: 108, 0
        //Ожидаемый результат: 108
        //Пояснение: 1101100 (108) -> 1101100 (108)
        actual = rotate(108, 0);
        expected = 108;
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Фильтрация отрицательных чисел")
    public void testNegative() {
        //Входные данные: -1, 1
        //Ожидаемый результат: -1
        //Пояснение: Число -1 меньше 0
        int actual = rotate(-1, 1);
        int expected = -1;
        assertEquals(expected, actual);

        //Входные данные: -18, 1
        //Ожидаемый результат: -1
        //Пояснение: Число -18 меньше 0
        actual = rotate(-18, 1);
        assertEquals(expected, actual);
    }

}
