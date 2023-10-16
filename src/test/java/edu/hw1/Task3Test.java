package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static edu.hw1.Task3.isNestable;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Task3Test {
    @Test
    @DisplayName("Проверка на правильность работы алгоритма")
    public void testCorrect() {
        //Входные данные: arr1: [1, 2, 3, 4], arr2: [0, 6]
        //Ожидаемый результат: True
        //Пояснение: Массив arr1 может быть вложен в массив arr2
        int[] arr1 = new int[] {1, 2, 3, 4};
        int[] arr2 = new int[] {0, 6};
        assertTrue(isNestable(arr1, arr2));

        //Входные данные: arr1: [3, 1], arr2: [4, 0]
        //Ожидаемый результат: True
        //Пояснение: Массив arr1 может быть вложен в массив arr2
        arr1 = new int[] {3, 1};
        arr2 = new int[] {4, 0};
        assertTrue(isNestable(arr1, arr2));

        //Входные данные: arr1: [9, 9, 8], arr2: [8, 9]
        //Ожидаемый результат: False
        //Пояснение: Массив arr1 не может быть вложен в массив arr2
        arr1 = new int[] {9, 9, 8};
        arr2 = new int[] {8, 9};
        assertFalse(isNestable(arr1, arr2));

        //Входные данные: arr1: [1, 2, 3, 4], arr2: [2, 3]
        //Ожидаемый результат: False
        //Пояснение: Массив arr1 не может быть вложен в массив arr2
        arr1 = new int[] {1, 2, 3, 4};
        arr2 = new int[] {2, 3};
        assertFalse(isNestable(arr1, arr2));

        //Входные данные: arr1: [0, 0, 0], arr2: [1, 2, 3]
        //Ожидаемый результат: False
        //Пояснение: Массив arr1 не может быть вложен в массив arr2
        arr1 = new int[] {0, 0, 0};
        arr2 = new int[] {1, 2, 3};
        assertFalse(isNestable(arr1, arr2));

        //Входные данные: arr1: [0, 6], arr2: [1, 2, 3, 4]
        //Ожидаемый результат: False
        //Пояснение: Массив arr1 не может быть вложен в массив arr2
        arr1 = new int[] {0, 6};
        arr2 = new int[] {1, 2, 3, 4};
        assertFalse(isNestable(arr1, arr2));
    }

    @Test
    @DisplayName("Проверка на пустой массив")
    public void testEmptyArray() {
        //Входные данные: arr1: [], arr2: [0, 6]
        //Ожидаемый результат: False
        //Пояснение: Массив arr1 пустой
        int[] arr1 = new int[0];
        int[] arr2 = new int[] {0, 6};
        assertFalse(isNestable(arr1, arr2));

        //Входные данные: arr1: [1, 2, 3, 4], arr2: []
        //Ожидаемый результат: False
        //Пояснение: Массив arr2 пустой
        arr1 = new int[] {1, 2, 3, 4};
        arr2 = new int[0];
        assertFalse(isNestable(arr1, arr2));

        //Входные данные: arr1: [], arr2: []
        //Ожидаемый результат: False
        //Пояснение: Массивы пустые
        arr1 = new int[0];
        assertFalse(isNestable(arr1, arr2));
    }

}
