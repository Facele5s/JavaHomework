package edu.hw7;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task1Test {
    @Test
    @DisplayName("Проверка счётчика")
    public void countTest() {
        MultiThreadCounter counter = new MultiThreadCounter(100);
        counter.startCounting(3);
    }

    @Test
    @DisplayName("Проверка потокобезопасности счётчика")
    public void threadSafetyTest() throws InterruptedException {
        MultiThreadCounter counter = new MultiThreadCounter(100);
        List<Thread> threads = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            Thread thread = new Thread(() -> {
                while (counter.getCount().get() < 100) {
                    counter.increment();
                }
            });

            threads.add(thread);
            thread.start();
        }

        for (Thread thread: threads) {
            thread.join();
        }

        assertEquals(counter.getCount().get(), 100);
    }
}
