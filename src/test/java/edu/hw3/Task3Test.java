package edu.hw3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.HashMap;
import java.util.Map;
import static edu.hw3.Task3.freqDict;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task3Test {
    @Test
    @DisplayName("Правильность работы частотного словаря")
    public void freqDictCorrectTest() {
        Map<Object, Integer> expected = new HashMap<>();
        expected.put("bb", 2);
        expected.put("a", 2);

        Object[] objects = new Object[] {"a", "bb", "a", "bb"};
        Map<Object, Integer> actual = freqDict(objects);

        assertEquals(expected, actual);

        //

        expected.clear();
        expected.put("that", 1);
        expected.put("and", 2);
        expected.put("this", 1);

        objects = new Object[] {"this", "and", "that", "and"};
        actual = freqDict(objects);

        assertEquals(expected, actual);

        //

        expected.clear();
        expected.put("код", 3);
        expected.put("bug", 1);

        objects = new Object[] {"код", "код", "код", "bug"};
        actual = freqDict(objects);

        assertEquals(expected, actual);

        //

        expected.clear();
        expected.put(1, 2);
        expected.put(2, 2);

        objects = new Object[] {1, 1, 2, 2};
        actual = freqDict(objects);

        assertEquals(expected, actual);

        //

        expected.clear();
        expected.put('C', 4);
        expected.put('O', 1);
        expected.put(101, 2);
        expected.put(0.5, 1);

        objects = new Object[] {'C', 'O', 'C', 101, 'C', 0.5, 'C', 101};
        actual = freqDict(objects);

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Проверка частотного словаря без входных данных")
    public void emptyInputTest() {
        Map<Object, Integer> expected = new HashMap<>();

        Object[] objects = new Object[0];
        Map<Object, Integer> actual = freqDict(objects);

        assertEquals(expected, actual);
    }
}
