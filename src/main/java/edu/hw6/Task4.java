package edu.hw6;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.zip.Adler32;
import java.util.zip.CheckedOutputStream;

public class Task4 {
    private static final String FILE_PATH = "src/main/resources/output_file.txt";
    private static final String MSG = "Programming is learned by writing programs. ― Brian Kernighan";

    private Task4() {

    }

    public static void writeMsgToFile() {
        try (OutputStream outputStream = Files.newOutputStream(Path.of(FILE_PATH));
             CheckedOutputStream checkedOutputStream = new CheckedOutputStream(outputStream, new Adler32());
             BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(checkedOutputStream);
             OutputStreamWriter outputStreamWriter =
                 new OutputStreamWriter(bufferedOutputStream, StandardCharsets.UTF_8);
             PrintWriter printWriter = new PrintWriter(outputStreamWriter)) {
            printWriter.write(MSG);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
