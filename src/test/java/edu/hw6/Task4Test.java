package edu.hw6;

import static edu.hw6.Task4.writeMsgToFile;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Task4Test {
    private static final String FILE_PATH = "src/main/resources/output_file.txt";
    private static final String MESSAGE = "Programming is learned by writing programs. ― Brian Kernighan";

    @Test
    @DisplayName("Проверка записи в файл")
    public void writeFileTest() {
        File file = new File(FILE_PATH);

        if (file.exists()) {
            file.delete();
        }

        writeMsgToFile();

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            assertEquals(reader.readLine(), MESSAGE);
        } catch (IOException e) {
            fail();
        }

        file.delete();
    }
}
