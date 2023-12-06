package edu.hw9.Task1;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class StatsCollector {
    private final ReadWriteLock lock = new ReentrantReadWriteLock();

    private final ExecutorService pool;
    private final List<Future<Double>> stats = new ArrayList<>();

    public StatsCollector(int numberOfThreads) {
        pool = Executors.newFixedThreadPool(numberOfThreads);
    }

    public void push(String metricType, double[] data) {
        lock.writeLock().lock();

        try {
            stats.add(pool.submit(() -> StatsCalculator.getMetric(metricType, data)));
        } finally {
            lock.writeLock().unlock();
        }
    }

    public List<Future<Double>> getStats() {
        lock.readLock().lock();

        try {
            return stats;
        } finally {
            lock.readLock().unlock();
        }
    }


}
