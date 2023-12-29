package edu.hw7;

import java.util.concurrent.atomic.AtomicInteger;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MultiThreadCounter {
    private final static Logger LOGGER = LogManager.getLogger();
    private final AtomicInteger count = new AtomicInteger(0);
    private final int n;

    public MultiThreadCounter(int n) {
        this.n = n;
    }

    public void startCounting(int threads) {
        for (int i = 0; i < threads; i++) {
            Thread thread = new Thread(() -> {
                for (int j = 0; j < n; j++) {
                    increment();
                }
            });

            thread.start();
        }
    }

    public synchronized void increment() {
        if (count.get() < n) {
            count.incrementAndGet();
            LOGGER.info(Thread.currentThread().getName() + ": " + count.get());
        }
    }

    public AtomicInteger getCount() {
        return count;
    }
}
