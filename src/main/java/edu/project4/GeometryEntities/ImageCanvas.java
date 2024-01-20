package edu.project4.GeometryEntities;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ImageCanvas {
    private static final ReadWriteLock LOCK = new ReentrantReadWriteLock();

    private Pixel[][] pixels;
    private int width;
    private int height;

    public ImageCanvas(int width, int height) {
        if (width <= 0 || height <= 0) {
            throw new IllegalArgumentException("Указан отрицательный размер");
        }

        this.width = width;
        this.height = height;
        this.pixels = new Pixel[height][width];

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                pixels[i][j] = new Pixel();
            }
        }
    }

    public Pixel[][] getPixels() {
        LOCK.readLock().lock();

        try {
            return pixels;
        } finally {
            LOCK.readLock().unlock();
        }
    }

    public Point pickRandomPoint(double xMax, double yMax) {
        double x = ThreadLocalRandom.current().nextDouble(-xMax, xMax);
        double y = ThreadLocalRandom.current().nextDouble(-yMax, yMax);

        return new Point(x, y);
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
