package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static edu.hw1.Task3.isNestable;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task3Test {
    @Test
    @DisplayName("Правильность результата")
    public void testCorrect() {
        int[] arr1 = new int[] {1, 2, 3, 4}; //True
        int[] arr2 = new int[] {0, 6};
        boolean actual = isNestable(arr1, arr2);
        boolean expected = true;
        assertEquals(expected, actual);

        arr1 = new int[] {3, 1}; //True
        arr2 = new int[] {4, 0};
        actual = isNestable(arr1, arr2);
        assertEquals(expected, actual);

        arr1 = new int[] {9, 9, 8};  //False
        arr2 = new int[] {8, 9};
        actual = isNestable(arr1, arr2);
        expected = false;
        assertEquals(expected, actual);

        arr1 = new int[] {1, 2, 3, 4};   //False
        arr2 = new int[] {2, 3};
        actual = isNestable(arr1, arr2);
        assertEquals(expected, actual);

        arr1 = new int[] {0, 0, 0};  //False
        arr2 = new int[] {1, 2, 3};
        actual = isNestable(arr1, arr2);
        assertEquals(expected, actual);

        arr1 = new int[] {0, 6}; //False
        arr2 = new int[] {1, 2, 3, 4};
        actual = isNestable(arr1, arr2);
        assertEquals(expected, actual);

        arr1 = new int[0];  //False
        arr2 = new int[0];
        actual = isNestable(arr1, arr2);
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Проверка на пустой массив")
    public void testEmptyArray() {
        int[] arr1 = new int[0];    //False
        int[] arr2 = new int[] {0, 6};
        boolean actual = isNestable(arr1, arr2);
        boolean expected = false;
        assertEquals(expected, actual);

        arr1 = new int[] {1, 2, 3, 4};   //False
        arr2 = new int[0];
        actual = isNestable(arr1, arr2);
        assertEquals(expected, actual);

        arr1 = new int[0];  //False
        actual = isNestable(arr1, arr2);
        assertEquals(expected, actual);
    }

}
