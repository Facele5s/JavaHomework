package edu.hw6;

import edu.hw6.Task3.Filters;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Set;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Task3Test {
    private static final String DIRECTORY = "src/main/java/edu/hw6/Task3";
    private static final Path PATH = Path.of(DIRECTORY);
    private static final Path TEXT1 = Path.of(DIRECTORY + "/123.txt");
    private static final Path TEXT2 = Path.of(DIRECTORY + "/text1.txt");
    private static final Path TEXT3 = Path.of(DIRECTORY + "/text2.txt");
    private static final Path IMAGE = Path.of(DIRECTORY + "/image.png");
    private static final Path JAVA1 = Path.of(DIRECTORY + "/Filters.java");
    private static final Path JAVA2 = Path.of(DIRECTORY + "/AbstractFilter.java");

    @Test
    @DisplayName("Фильтр по атрибутам файла")
    public void attributesFilterTest() throws IOException {
        Set<Path> paths = Set.of(TEXT1, TEXT2, TEXT3, JAVA1, JAVA2, IMAGE);

        Files.newDirectoryStream(PATH, Filters.REGULAR_FILE).forEach(path -> {
            assertTrue(paths.contains(path));
        });

        Files.newDirectoryStream(PATH, Filters.READABLE).forEach(path -> {
            assertTrue(paths.contains(path));
        });

        Files.newDirectoryStream(PATH, Filters.WRITABLE).forEach(path -> {
            assertTrue(paths.contains(path));
        });
    }

    @Test
    @DisplayName("Фильтр по размерам файла")
    public void fileSizeFilterTest() throws IOException {
        Set<Path> smallFiles = Set.of(IMAGE, TEXT1);
        Set<Path> hugeFiles = Set.of(JAVA1, JAVA2);

        Files.newDirectoryStream(PATH, Filters.largerThan(100)).forEach(path -> {
            assertTrue(hugeFiles.contains(path));
        });

        Files.newDirectoryStream(PATH, Filters.smallerThan(1)).forEach(path -> {
            assertTrue(smallFiles.contains(path));
        });
    }

    @Test
    @DisplayName("Фильтр по расширению файла")
    public void extensionFilterTest() throws IOException {
        Set<Path> textFiles = Set.of(TEXT1, TEXT2, TEXT3);

        Files.newDirectoryStream(PATH, Filters.extensionMatches("txt")).forEach(path -> {
            assertTrue(textFiles.contains(path));
        });
    }

    @Test
    @DisplayName("Фильтр по названию файла")
    public void fileNameFilterTest() throws IOException {
        Set<Path> paths = Set.of(TEXT2, TEXT3);

        Files.newDirectoryStream(PATH, Filters.regexMatches("text\\d+\\..+")).forEach(path -> {
            assertTrue(paths.contains(path));
        });
    }

    @Test
    @DisplayName("Фильтр по магическим числам")
    public void magicNumberTest() throws IOException {
        byte[] bytes = new byte[]{
            (byte) 't',
            (byte) 'e',
            (byte) 'x',
            (byte) 't'
        };

        Files.newDirectoryStream(PATH, Filters.magicNumber(bytes)).forEach(path -> {
            assertEquals(path, TEXT3);
        });
    }
}
