package edu.hw8.Task2;

import java.util.Arrays;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class FixedThreadPool implements ThreadPool {
    private final int numberOfThreads;
    private final Thread[] threads;
    private final BlockingQueue<Runnable> queue;


    private FixedThreadPool(int nThreads) {
        this.numberOfThreads = nThreads;
        this.threads = new Thread[nThreads];
        this.queue = new ArrayBlockingQueue<>(nThreads);
    }

    public static FixedThreadPool create(int nThreads) {
        return new FixedThreadPool(nThreads);
    }

    @Override
    public void start() {
        for (int i = 0; i < numberOfThreads; i++) {
            threads[i] = new Thread(() -> {
                while (!Thread.currentThread().isInterrupted()) {
                    try {
                        Runnable task = queue.take();
                        task.run();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            });

            threads[i].start();
        }
    }

    @Override
    public void execute(Runnable runnable) {
        try {
            queue.put(runnable);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    @Override
    public void close() throws Exception {
        Arrays.stream(threads).forEach(Thread::interrupt);
    }
}
