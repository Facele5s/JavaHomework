package edu.hw7.Task4;

import java.util.Random;

@SuppressWarnings("MagicNumber")
public class SinglethreadPICalculator {
    private static final Random RANDOM = new Random();

    private static final int WIDTH = 999;
    private static final int RADIUS = 499;
    private static final int CIRCLE_CENTER = 499;

    private SinglethreadPICalculator() {

    }

    public static double calculatePI(int iterations) {
        if (iterations <= 0) {
            throw new IllegalArgumentException("Указано количество итераций меньшее или равное 0");
        }

        int circleCount = countPoints(iterations);

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
        return RANDOM.nextInt(WIDTH);
    }

    private static boolean isPointInCircle(int x, int y) {
        return Math.sqrt(Math.pow(CIRCLE_CENTER - x, 2) + Math.pow(CIRCLE_CENTER - y, 2)) <= RADIUS;
    }
}
