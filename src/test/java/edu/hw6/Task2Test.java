package edu.hw6;

import static edu.hw6.Task2.Task2.cloneFile;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.io.File;
import java.io.IOException;

public class Task2Test {
    private static final String FILE_ORIGINAL = "src/main/java/edu/hw6/Task2/file.txt";
    private static final String FILE_FIRST_COPY = "src/main/java/edu/hw6/Task2/file - копия.txt";
    private static final String FILE_COPY_COPY = "src/main/java/edu/hw6/Task2/file - копия - копия.txt";
    private static final String FILE_SECOND_COPY = "src/main/java/edu/hw6/Task2/file - копия (2).txt";

    @Test
    @DisplayName("Создание первой копии")
    public void firstCopyTest() throws IOException  {
        File file_original = new File(FILE_ORIGINAL);
        File file_copy = new File(FILE_FIRST_COPY);

        if (file_copy.exists()) {
            file_copy.delete();
        }

        cloneFile(file_original.toPath());

        assertTrue(file_copy.exists());
    }

    @Test
    @DisplayName("Создание второй копии подряд")
    public void secondCopyTest() throws IOException  {
        File file_original = new File(FILE_ORIGINAL);
        File file_copy = new File(FILE_FIRST_COPY);
        File file_copy2 = new File(FILE_SECOND_COPY);

        if (file_copy.exists()) {
            file_copy.delete();
        }
        if (file_copy2.exists()) {
            file_copy2.delete();
        }

        cloneFile(file_original.toPath());
        cloneFile(file_original.toPath());

        assertTrue(file_copy.exists() && file_copy2.exists());
    }

    @Test
    @DisplayName("Создание промежуточной копии")
    public void middleCopyTest() throws IOException {
        File file_original = new File(FILE_ORIGINAL);
        File file_copy = new File(FILE_FIRST_COPY);
        File file_copy2 = new File(FILE_SECOND_COPY);

        if (file_copy.exists()) {
            file_copy.delete();
        }
        if (!file_copy2.exists()) {
            file_copy2.createNewFile();
        }

        cloneFile(file_original.toPath());

        assertTrue(file_copy.exists() && file_copy2.exists());
    }

    @Test
    @DisplayName("Создание копии копии файла")
    public void copyCopiedFileTest() throws IOException {
        File file_original = new File(FILE_ORIGINAL);
        File file_copy = new File(FILE_FIRST_COPY);
        File file_copy_copy = new File(FILE_COPY_COPY);

        if (file_copy.exists()) {
            file_copy.delete();
        }
        if (file_copy_copy.exists()) {
            file_copy_copy.delete();
        }

        cloneFile(file_original.toPath());
        cloneFile(file_copy.toPath());

        assertTrue(file_copy_copy.exists());
    }

}
