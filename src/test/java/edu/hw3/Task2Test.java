package edu.hw3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static edu.hw3.Task2.clusterize;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class Task2Test {
    @Test
    @DisplayName("Фильтрация посторонних символов")
    public void invalidCharsTest() {
        String[] actual = clusterize("123()");
        String[] expected = new String[0];
        assertArrayEquals(expected, actual);
    }

    @Test
    @DisplayName("Проверка правильности кластеризации")
    public void clusterizingTest() {
        String[] actual = clusterize("()()()");
        String[] expected = new String[] {"()", "()", "()"};
        assertArrayEquals(expected, actual);

        actual = clusterize("((()))");
        expected = new String[] {"((()))"};
        assertArrayEquals(expected, actual);

        actual = clusterize("((()))(())()()(()())");
        expected = new String[] {"((()))", "(())", "()", "()", "(()())"};
        assertArrayEquals(expected, actual);

        actual = clusterize("((())())(()(()()))");
        expected = new String[] {"((())())", "(()(()()))"};
        assertArrayEquals(expected, actual);

        actual = clusterize("()(()())()((()()))");
        expected = new String[] {"()", "(()())", "()", "((()()))"};
        assertArrayEquals(expected, actual);
    }

    @Test
    @DisplayName("Проверка на несбалансированные кластеры")
    public void invalidClusterTest() {
        String[] actual = clusterize("((");
        String[] expected = new String[0];
        assertArrayEquals(expected, actual);

        actual = clusterize("()(");
        expected = new String[0];
        assertArrayEquals(expected, actual);

        actual = clusterize("))");
        expected = new String[0];
        assertArrayEquals(expected, actual);

        actual = clusterize("())");
        expected = new String[0];
        assertArrayEquals(expected, actual);
    }

    @Test
    @DisplayName("Проверка кластеризации на пустой строке")
    public void emptyStringTest() {
        String[] actual = clusterize("");
        String[] expected = new String[0];
        assertArrayEquals(expected, actual);
    }
}
