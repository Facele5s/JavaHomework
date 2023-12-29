package edu.hw7.Task4;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadLocalRandom;

@SuppressWarnings("MagicNumber")
public class MultithreadPICalculator {
    private static final int WIDTH = 999;
    private static final int RADIUS = 499;
    private static final int CIRCLE_CENTER = 499;

    private MultithreadPICalculator() {

    }

    public static double calculatePI(int iterations, int threads) {
        if (iterations < 0) {
            throw new IllegalArgumentException("Указано количество итераций меньше 0");
        }

        int circleCount = 0;

        try (ExecutorService service = Executors.newFixedThreadPool(threads)) {
            int iterationsPerThread = iterations / threads;

            Future<Integer>[] counts = new Future[threads];
            for (int i = 0; i < threads; i++) {
                counts[i] = service.submit(() -> countPoints(iterationsPerThread));
            }

            for (int i = 0; i < threads; i++) {
                circleCount += counts[i].get();
            }

            service.shutdown();
        } catch (ExecutionException | InterruptedException e) {
            throw new RuntimeException(e);
        }

        return 4D * circleCount / iterations;
    }

    private static int countPoints(int iterations) {
        int count = 0;

        for (int i = 0; i < iterations; i++) {
            int x = pickRandomCoordinate();
            int y = pickRandomCoordinate();

            if (isPointInCircle(x, y)) {
                count++;
            }
        }

        return count;
    }

    private static int pickRandomCoordinate() {
        return ThreadLocalRandom.current().nextInt(WIDTH);
    }

    private static boolean isPointInCircle(int x, int y) {
        return Math.sqrt(Math.pow(CIRCLE_CENTER - x, 2) + Math.pow(CIRCLE_CENTER - y, 2)) <= RADIUS;
    }
}
