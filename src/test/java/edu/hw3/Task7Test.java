package edu.hw3;

import edu.hw3.Task7.NullTreeMap;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.TreeMap;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Task7Test {
    @Test
    @DisplayName("Проверка на наличие ключа null")
    void containsNullTest() {
        TreeMap<String, String> treeMap = new NullTreeMap<>();

        treeMap.put(null, "Not null string");
        assertTrue(treeMap.containsKey(null));

        treeMap.put(null, null);
        assertTrue(treeMap.containsKey(null));
    }
}
