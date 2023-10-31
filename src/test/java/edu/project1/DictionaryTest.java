package edu.project1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

public class DictionaryTest {
    @Test
    @DisplayName("Проверка на несуществующий файл")
    public void fileNotFoundTest() {
        try {
            new Dictionary("src/main/resources/randomfile.txt");
        } catch (Exception e) {
            assertTrue(e instanceof FileNotFoundException);
        }
    }

    @Test
    @DisplayName("Проверка на пустой файл")
    public void emptyFileTest() {
        try {
            new Dictionary("src/main/resources/EmptyDictionary1.txt");
        } catch (Exception e) {
            System.out.println(e);
            assertTrue(e instanceof NoSuchElementException);
        }

        try {
            new Dictionary("src/main/resources/EmptyDictionary2.txt");
        } catch (Exception e) {
            assertTrue(e instanceof NoSuchElementException);
        }
    }

    @Test
    @DisplayName("Проверка на неверно заполненный файл")
    public void wrongFileTest() {
        try {
            new Dictionary("src/main/resources/WrongDictionary.txt");
        } catch (Exception e) {
            assertTrue(e instanceof WrongInputFormatException);
        }
    }

    @Test
    @DisplayName("Проверка правильности словаря")
    public void correctDictionaryTest() {
        try {
            new Dictionary("src/main/resources/GameWords.txt");
            assertTrue(true);
        } catch (Exception e) {
            fail();
        }
    }
}
