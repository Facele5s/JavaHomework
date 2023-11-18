package edu.hw6;

import edu.hw6.Task1.DiskMap;
import edu.hw6.Task1.FileHandler;
import edu.hw6.Task1.WrongFileFormatException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.io.File;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

public class Task1Test {
    private static final String DISKMAP_FILE_NOT_EXISTS = "src/main/java/edu/hw6/Task1/Diskmap_NOT_EXISTS.txt";
    private static final String DISKMAP_FILE_WRONG_FORMAT = "src/main/java/edu/hw6/Task1/Diskmap_WRONG_FORMAT.txt";
    private static final String DISKMAP_FILE_CORRECT = "src/main/java/edu/hw6/Task1/Diskmap_CORRECT.txt";
    private static final String DISKMAP_FILE = "src/main/java/edu/hw6/Task1/Diskmap.txt";

    @Test
    @DisplayName("Проверка инициализации DiskMap")
    public void diskMapInitTest() {
        try {
            File file = new File(DISKMAP_FILE_NOT_EXISTS);
            if (file.exists()) {
                file.delete();
            }

            new DiskMap(DISKMAP_FILE_NOT_EXISTS);
            assertTrue(true);

            file.delete();
        } catch (Exception e) {
            fail();
        }

        try {
            new DiskMap(DISKMAP_FILE_WRONG_FORMAT);
            fail();
        } catch (Exception e) {
            assertTrue(e instanceof WrongFileFormatException);
        }

        try {
            new DiskMap(DISKMAP_FILE_CORRECT);
            assertTrue(true);
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    @DisplayName("Извлечение всех данных из файла")
    public void getAllDataTest() {
        DiskMap diskMap;

        try {
            diskMap = new DiskMap(DISKMAP_FILE_CORRECT);
        } catch (Exception e) {
            fail();
            return;
        }

        Set<String> keySet = new HashSet<>(List.of("a", "b", "c"));
        Set<String> values = new HashSet<>(List.of("1", "2", "3"));
        Map<String, String> map = new HashMap<>();
        map.put("a", "1");
        map.put("b", "2");
        map.put("c", "3");

        assertEquals(keySet.size(), diskMap.size());
        assertEquals(values.size(), diskMap.size());
        assertEquals(keySet.size(), values.size());

        assertEquals(keySet, diskMap.keySet());
        assertEquals(values, diskMap.values());

        assertEquals(map.entrySet(), diskMap.entrySet());
    }

    @Test
    @DisplayName("Чтение одного значения")
    public void readOneValue() {
        DiskMap diskMap;

        try {
            diskMap = new DiskMap(DISKMAP_FILE_CORRECT);
        } catch (Exception e) {
            fail();
            return;
        }

        assertEquals(diskMap.get("a"), "1");
        assertEquals(diskMap.get("b"), "2");
        assertEquals(diskMap.get("c"), "3");
        assertNull(diskMap.get("d"));
    }

    @Test
    @DisplayName("Запись одного значения")
    public void putOneValue() {
        File file = new File(DISKMAP_FILE);
        if (file.exists()) {
            file.delete();
        }

        DiskMap diskMap;

        try {
            diskMap = new DiskMap(DISKMAP_FILE);
        } catch (Exception e) {
            fail();
            return;
        }

        FileHandler fileHandler = new FileHandler(file);

        diskMap.put("a", "1");
        assertTrue(fileHandler.readKeys().contains("a"));
        assertTrue(fileHandler.readValues().contains("1"));

        diskMap.put("b", "2");
        assertTrue(fileHandler.readKeys().contains("b"));
        assertTrue(fileHandler.readValues().contains("2"));

        diskMap.put("c", "3");
        assertTrue(fileHandler.readKeys().contains("c"));
        assertTrue(fileHandler.readValues().contains("3"));

        diskMap.put("b", "B");
        assertTrue(fileHandler.readKeys().contains("b"));
        assertTrue(fileHandler.readValues().contains("B"));

        assertEquals(fileHandler.readKeys(), diskMap.keySet());
        assertEquals(fileHandler.readValues(), diskMap.values());
    }

    @Test
    @DisplayName("Удаление одного значения")
    public void removeOneValue() {
        File file = new File(DISKMAP_FILE);
        if (file.exists()) {
            file.delete();
        }

        DiskMap diskMap;

        try {
            diskMap = new DiskMap(DISKMAP_FILE);
        } catch (Exception e) {
            fail();
            return;
        }

        FileHandler fileHandler = new FileHandler(file);

        diskMap.put("a", "1");
        diskMap.put("b", "2");
        diskMap.put("c", "3");
        assertEquals(fileHandler.readKeys(), diskMap.keySet());
        assertEquals(fileHandler.readValues(), diskMap.values());

        assertFalse(fileHandler.readKeys().contains("d"));
        diskMap.remove("d");
        assertFalse(fileHandler.readKeys().contains("d"));

        diskMap.remove("a");
        assertFalse(fileHandler.readKeys().contains("a"));

        diskMap.remove("b");
        assertFalse(fileHandler.readKeys().contains("b"));

        diskMap.remove("c");
        assertFalse(fileHandler.readKeys().contains("c"));
    }

    @Test
    @DisplayName("Запись набора значений")
    public void putAllTest() {
        File file = new File(DISKMAP_FILE);
        if (file.exists()) {
            file.delete();
        }

        DiskMap diskMap;

        try {
            diskMap = new DiskMap(DISKMAP_FILE);
        } catch (Exception e) {
            fail();
            return;
        }

        FileHandler fileHandler = new FileHandler(file);

        Map<String, String> map = new HashMap<>();
        map.put("abc", "def");
        map.put("ghi", "jkl");
        map.put("mno", "pqr");

        diskMap.putAll(map);
        assertTrue(map.keySet().containsAll(fileHandler.readKeys()));
        assertTrue(map.values().containsAll(fileHandler.readValues()));
    }

    @Test
    @DisplayName("Удаление всех значений")
    public void clearData() {
        File file = new File(DISKMAP_FILE);
        if (file.exists()) {
            file.delete();
        }

        DiskMap diskMap;

        try {
            diskMap = new DiskMap(DISKMAP_FILE);
        } catch (Exception e) {
            fail();
            return;
        }

        FileHandler fileHandler = new FileHandler(file);

        Map<String, String> map = new HashMap<>();
        map.put("abc", "def");
        map.put("ghi", "jkl");
        map.put("mno", "pqr");

        diskMap.clear();
        assertTrue(fileHandler.readKeys().isEmpty());
        assertTrue(fileHandler.readValues().isEmpty());
        assertTrue(diskMap.isEmpty());
    }
}
