package edu.hw6.Task3;

import java.nio.file.Files;

public class Filters {
    public static final AbstractFilter REGULAR_FILE = Files::isRegularFile;

    public static final AbstractFilter READABLE = Files::isReadable;

    public static final AbstractFilter WRITABLE = Files::isWritable;

    private Filters() {

    }

    public static AbstractFilter largerThan(int size) {
        return path -> Files.size(path) > size;
    }

    public static AbstractFilter smallerThan(int size) {
        return path -> Files.size(path) < size;
    }

    public static AbstractFilter extensionMatches(String extension) {
        return path -> path.getFileName().toString()
            .matches("^[^.]+$" + "." + extension);
    }

    public static AbstractFilter regexMatches(String regex) {
        return path -> path.getFileName().toString().matches(regex);
    }

    public static AbstractFilter magicNumber(byte... magicNumbers) {
        return path -> {
            byte[] fileBytes = Files.readAllBytes(path);
            if (magicNumbers.length > fileBytes.length) {
                return false;
            }

            for (int i = 0; i < magicNumbers.length; i++) {
                if (magicNumbers[i] != fileBytes[i]) {
                    return false;
                }
            }

            return true;
        };
    }
}
