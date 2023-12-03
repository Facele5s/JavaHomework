package edu.hw8;

import edu.hw8.Task2.FixedThreadPool;
import edu.hw8.Task2.ThreadPool;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Task2Test {
    private static final Logger LOGGER = LogManager.getLogger();
    private static final int N = 30;

    @Test
    @DisplayName("Многопоточное вычисление чисел Фибоначчи")
    public void multithreadFibonacciTest() {
        try (ThreadPool pool = FixedThreadPool.create(N)) {
            pool.start();

            for (int i = 0; i < N; i++) {
                int j = i;
                pool.execute(() -> {
                    long number = getFibonacciNumber(j);
                    LOGGER.info(String.format("Число Фибоначчи (%d): %d", j, number));
                });
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    private long getFibonacciNumber(int n) {
        if (n <= 1) {
            return n;
        }

        return getFibonacciNumber(n - 1) + getFibonacciNumber(n - 2);
    }
}
