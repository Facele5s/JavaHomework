package edu.hw4;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import org.jetbrains.annotations.NotNull;

public class ValidationError implements Comparable {
    public static final ValidationError NULL_NAME =
        new ValidationError("Имя не указано");
    public static final ValidationError EMPTY_NAME =
        new ValidationError("Пустое имя");
    public static final ValidationError INVALID_NAME =
        new ValidationError("Имя содержит постороенние символы");
    public static final ValidationError NULL_TYPE =
        new ValidationError("Тип животного не указан");
    public static final ValidationError NULL_SEX =
        new ValidationError("Пол животного не указан");
    public static final ValidationError NEGATIVE_AGE =
        new ValidationError("Отрицательный возраст");
    public static final ValidationError ZERO_AGE =
        new ValidationError("Нулевой возраст");
    public static final ValidationError NEGATIVE_WEIGHT =
        new ValidationError("Отрицательный вес");
    public static final ValidationError ZERO_WEIGHT =
        new ValidationError("Нулевой вес");
    public static final ValidationError NEGATIVE_HEIGHT =
        new ValidationError("Отрицательный рост");
    public static final ValidationError ZERO_HEIGHT =
        new ValidationError("Нулевой рост");

    private final String errorMessage;

    public ValidationError(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public static Set<ValidationError> checkAnimal(Animal animal) {
        Set<ValidationError> result = new HashSet<>();

        if (animal.name() == null) {
            result.add(NULL_NAME);
        } else if (animal.name().isEmpty()) {
            result.add(EMPTY_NAME);
        } else if (animal.name().chars().filter(n -> {
            char c = (char) n;
            return !Character.isLetter(c) && c != ' ';
        }).findAny().isPresent()) {
            result.add(INVALID_NAME);
        }

        if (animal.type() == null) {
            result.add(NULL_TYPE);
        }

        if (animal.sex() == null) {
            result.add(NULL_SEX);
        }

        if (animal.age() < 0) {
            result.add(NEGATIVE_AGE);
        } else if (animal.age() == 0) {
            result.add(ZERO_AGE);
        }

        if (animal.height() < 0) {
            result.add(NEGATIVE_HEIGHT);
        } else if (animal.height() == 0) {
            result.add(ZERO_HEIGHT);
        }

        if (animal.weight() < 0) {
            result.add(NEGATIVE_WEIGHT);
        } else if (animal.weight() == 0) {
            result.add(ZERO_WEIGHT);
        }

        return result;
    }

    public static Map<String, String> beautifulCheck(Animal animal) {
        Set<ValidationError> rawValidation = checkAnimal(animal);
        Map<String, String> result = new HashMap<>();

        String errors = rawValidation.stream()
            .map(e -> e.errorMessage)
            .sorted((s1, s2) -> {
                if (s1.length() > s2.length()) {
                    return 1;
                } else if (s1.length() < s2.length()) {
                    return -1;
                } else if (s1.charAt(0) > s2.charAt(0)) {
                    return 1;
                }
                return -1;
            })
            .collect(Collectors.joining(", "));

        result.put(animal.name(), errors);

        return result;
    }

    @Override
    public int compareTo(@NotNull Object o) {
        ValidationError e = (ValidationError) o;

        return this.errorMessage.length() - e.errorMessage.length();
    }

    @Override
    public boolean equals(Object obj) {
        ValidationError e = (ValidationError) obj;
        return this.errorMessage.equals(e.errorMessage);
    }

    @Override public String toString() {
        return "Error: " + errorMessage;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
