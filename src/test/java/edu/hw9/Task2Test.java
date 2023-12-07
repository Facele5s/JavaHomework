package edu.hw9;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Task2Test {
    private void createFilesForTest() throws IOException {
        String path = "src/main/java/edu/hw9/Task2/d";
        Files.deleteIfExists(Path.of(path));
        File file = new File(path)

    }
}
