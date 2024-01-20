package edu.hw7;

import java.util.stream.LongStream;

public class Task2 {
    private Task2() {

    }

    public static long factorialParallel(long n) throws IllegalArgumentException {
        if (n < 0) {
            throw new IllegalArgumentException("Передано отрицательное число");
        }

        return LongStream.rangeClosed(1, n)
            .parallel()
            .reduce((a, b) -> a * b)
            .orElse(1);
    }
}
