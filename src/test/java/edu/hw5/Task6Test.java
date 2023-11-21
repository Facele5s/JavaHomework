package edu.hw5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static edu.hw5.Task6.isSubstring;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Task6Test {
    @Test
    @DisplayName("Проверка на вхождение одной строки в другую")
    public void substringTest() {
        assertTrue(isSubstring("abc", "achfdbaabgabcaabg"));
        assertTrue(isSubstring("is", "London is the capital"));
        assertTrue(isSubstring("\\", "awdafhhftan\\hfttwd"));
        assertTrue(isSubstring("\n", "awdafhhftan\nhfttwd"));
        assertTrue(isSubstring("[]", "awdaf[]hhftan\\hfttwd"));
        assertTrue(isSubstring("", "123123"));
        assertTrue(isSubstring("", ""));

        assertFalse(isSubstring("[]", "awdaf[213]hhftan\\hfttwd"));
        assertFalse(isSubstring("abc", "qweryuioiuytr"));
        assertFalse(isSubstring("\\d", "123123"));
    }

    @Test
    @DisplayName("Проверка на null")
    public void nullTest() {
        assertFalse(isSubstring(null, "abcde"));
        assertFalse(isSubstring("abcde", null));
        assertFalse(isSubstring(null, null));
    }
}
