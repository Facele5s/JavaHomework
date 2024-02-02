package edu.hw8.Task3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Collectors;

public class FileParser {
    private FileParser() {

    }

    public static ConcurrentMap<String, String> readPasswords(String path) throws IOException {
        File file = new File(path);

        if (!checkFileStyle(file)) {
            throw new IllegalArgumentException("Файл заполнен в неверном формате");
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            return reader.lines().map(s -> s.split(" "))
                .collect(Collectors.toConcurrentMap(s -> s[1], s -> s[0]));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static boolean checkFileStyle(File file) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            return reader.lines().allMatch(s -> s.matches("^[\\w.]+ [A-Za-z0-9]+$"));
        }
    }
}
