package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static edu.hw1.Task6.countK;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task6Test {
    @Test
    @DisplayName("Результаты работы алгоритма совпадают с ожиданиями")
    public void testCorrect() {
        //Входные данные: 3524
        //Ожидаемый результат: 3
        //Пояснение: Потребуется 3 шага, чтобы получить постоянную Капрекара
        int actual = countK(3524);
        int expected = 3;
        assertEquals(expected, actual);

        //Входные данные: 6621
        //Ожидаемый результат: 5
        //Пояснение: Потребуется 5 шагов, чтобы получить постоянную Капрекара
        actual = countK(6621);
        expected = 5;
        assertEquals(expected, actual);

        //Входные данные: 6554
        //Ожидаемый результат: 4
        //Пояснение: Потребуется 4 шага, чтобы получить постоянную Капрекара
        actual = countK(6554);
        expected = 4;
        assertEquals(expected, actual);

        //Входные данные: 1234
        //Ожидаемый результат: 3
        //Пояснение: Потребуется 3 шага, чтобы получить постоянную Капрекара
        actual = countK(1234);
        expected = 3;
        assertEquals(expected, actual);

        //Входные данные: 6174
        //Ожидаемый результат: 0
        //Пояснение: Потребуется 0 шагов, чтобы получить постоянную Капрекара
        actual = countK(6174);
        expected = 0;
        assertEquals(expected, actual);

        //Входные данные: 1001
        //Ожидаемый результат: 4
        //Пояснение: Потребуется 4 шага, чтобы получить постоянную Капрекара
        actual = countK(1001);
        expected = 4;
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Фильтрация чисел меньше 1000")
    public void testSmallNumbers() {
        //Входные данные: 999
        //Ожидаемый результат: -1
        //Пояснение: Число меньше 1000
        int actual = countK(999);
        int expected = -1;
        assertEquals(expected, actual);

        //Входные данные: 0
        //Ожидаемый результат: -1
        //Пояснение: Число меньше 1000
        actual = countK(0);
        assertEquals(expected, actual);

        //Входные данные: -87
        //Ожидаемый результат: -1
        //Пояснение: Число меньше 1000
        actual = countK(-87);
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Фильтрация чисел больше 9999")
    public void testBigNumbers() {
        //Входные данные: 10348
        //Ожидаемый результат: -1
        //Пояснение: Число превышает 9999
        int actual = countK(10348);
        int expected = -1;
        assertEquals(expected, actual);

        //Входные данные: 249129712
        //Ожидаемый результат: -1
        //Пояснение: Число превышает 9999
        actual = countK(249129712);
        assertEquals(expected, actual);

        //Входные данные: 10000
        //Ожидаемый результат: -1
        //Пояснение: Число превышает 9999
        actual = countK(10000);
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Фильтрация чисел с одинаковыми цифрами")
    public void testEqualDigits() {
        //Входные данные: 1111
        //Ожидаемый результат: -1
        //Пояснение: Число состоит из одинаковых цифр
        int actual = countK(1111);
        int expected = -1;
        assertEquals(expected, actual);

        //Входные данные: 3333
        //Ожидаемый результат: -1
        //Пояснение: Число состоит из одинаковых цифр
        actual = countK(3333);
        assertEquals(expected, actual);

        //Входные данные: 9999
        //Ожидаемый результат: -1
        //Пояснение: Число состоит из одинаковых цифр
        actual = countK(9999);
        assertEquals(expected, actual);
    }

}
