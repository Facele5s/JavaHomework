package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static edu.hw1.Task1.minutesToSeconds;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task1Test {
    @Test
    @DisplayName("Строка не является пустой")
    public void testEmpty() {
        //Входные данные: ""
        //Ожидаемый результат: -1
        //Пояснение: Ошибка. Строка пустая
        int actual = minutesToSeconds("");
        int expected = -1;
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Строка не является null")
    public void testNull() {
        //Входные данные: null
        //Ожидаемый результат: -1
        //Пояснение: Ошибка. Строка равна null
        int actual = minutesToSeconds(null);
        int expected = -1;
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Строка состоит только из цифр И одного двоеточия")
    public void testDigitsColon() {
        //Входные данные: "1ab2"
        //Ожидаемый результат: -1
        //Пояснение: Ошибка. Строка не содержит двоеточия и содержит буквенные символы
        int actual = minutesToSeconds("1ab2");
        int expected = -1;
        assertEquals(expected, actual);

        //Входные данные: ":"
        //Ожидаемый результат: -1
        //Пояснение: Ошибка. Строка не содержит цифр
        actual = minutesToSeconds(":");
        assertEquals(expected, actual);

        //Входные данные: "12: 34"
        //Ожидаемый результат: -1
        //Пояснение: Ошибка. Строка содержит пробел
        actual = minutesToSeconds("12: 34");
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Строка не содержит больше одного двоеточия")
    public void testOneColon() {
        //Входные данные: "12::34"
        //Ожидаемый результат: -1
        //Пояснение: Ошибка. Строка содержит два двоеточия
        int actual = minutesToSeconds("12::34");
        int expected = -1;
        assertEquals(expected, actual);

        //Входные данные: "1:2:34"
        //Ожидаемый результат: -1
        //Пояснение: Ошибка. Строка содержит два двоеточия
        actual = minutesToSeconds("1:2:34");
        assertEquals(expected, actual);

        //Входные данные: "1::::16"
        //Ожидаемый результат: -1
        //Пояснение: Ошибка. Строка содержит четыре двоеточия
        actual = minutesToSeconds("1::::16");
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Строка не содержит двоеточие в начале или конце")
    public void testColonAtTheEdge() {
        //Входные данные: ":1234"
        //Ожидаемый результат: -1
        //Пояснение: Ошибка. Двоеточие находится в начале строки
        int actual = minutesToSeconds(":1234");
        int expected = -1;
        assertEquals(expected, actual);

        //Входные данные: "1234:"
        //Ожидаемый результат: -1
        //Пояснение: Ошибка. Двоеточие находится в конце строки
        actual = minutesToSeconds("1234:");
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Количество секунд меньше 60")
    public void testSeconds() {
        //Входные данные: "12:720"
        //Ожидаемый результат: -1
        //Пояснение: Ошибка. Количество секунд превышает 60
        int actual = minutesToSeconds("12:720");
        int expected = -1;
        assertEquals(expected, actual);

        //Входные данные: "52245:19190"
        //Ожидаемый результат: -1
        //Пояснение: Ошибка. Количество секунд превышает 60
        actual = minutesToSeconds("52245:19190");
        assertEquals(expected, actual);

        //Входные данные: "10:60"
        //Ожидаемый результат: -1
        //Пояснение: Ошибка. Количество секунд равно 60
        actual = minutesToSeconds("10:60");
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Проверка корректных строк")
    public void testCorrect() {
        //Входные данные: "01:00"
        //Ожидаемый результат: 60
        int actual = minutesToSeconds("01:00");
        int expected = 60;
        assertEquals(expected, actual);

        //Входные данные: "13:56"
        //Ожидаемый результат: 836
        actual = minutesToSeconds("13:56");
        expected = 836;
        assertEquals(expected, actual);

        //Входные данные: "1216:59"
        //Ожидаемый результат: 73019
        actual = minutesToSeconds("1216:59");
        expected = 73019;
        assertEquals(expected, actual);
    }

}
