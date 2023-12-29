package edu.hw6.Task1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class FileHandler {
    private final File file;
    private final File tempFile;

    public FileHandler(File file) {
        this.file = file;
        tempFile = new File(file.getParent() + "/temp.txt");
    }

    public boolean checkFileFormat() {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            return reader.lines()
                .filter(str -> !str.matches("^[^:]+:[^:]+$")).findFirst().isEmpty();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Set<String> readKeys() {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            return reader.lines()
                .map(str -> str.split(":")[0])
                .collect(Collectors.toSet());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Set<String> readValues() {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            return reader.lines()
                .map(str -> str.split(":")[1])
                .collect(Collectors.toSet());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Set<Map.Entry<String, String>> readEntrySets() {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            return reader.lines()
                .map(str -> str.split(":"))
                .collect(Collectors.toMap(str -> str[0], str -> str[1])).entrySet();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String readValueByKey(String key) {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            return reader.lines()
                .map(str -> str.split(":"))
                .filter(str -> str[0].equals(key))
                .map(str -> str[1]).findFirst().orElse(null);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void clearFile() {
        try (BufferedWriter writer = new BufferedWriter(new PrintWriter(file))) {
            writer.write("");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String writeToTemp(String keyToRemove, List<String> lines) {
        try (BufferedReader reader = new BufferedReader(new FileReader(file));
             BufferedWriter writer = new BufferedWriter(new PrintWriter(tempFile))) {
            String value = readValueByKey(keyToRemove);

            // Записываем все записи кроме удаляемой во временный файл
            reader.lines()
                .filter(str -> !str.split(":")[0].equals(keyToRemove))
                .forEach(str -> {
                    try {
                        writer.write(str + "\n");
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                });

            if (lines != null) {
                lines.forEach(line -> {
                    try {
                        writer.write(keyToRemove + ":" + line + "\n");
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                });
            }

            return value;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void loadFromTemp() {
        try (BufferedReader reader = new BufferedReader(new FileReader(tempFile));
             BufferedWriter writer = new BufferedWriter(new PrintWriter(file))) {
            reader.lines().forEach(line -> {
                try {
                    writer.write(line + "\n");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteTemp() {
        tempFile.delete();
    }

}
