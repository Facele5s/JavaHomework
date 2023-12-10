package edu.project4.GeometryEntities;

import java.awt.Color;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Pixel {
    private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock(true);
    private Color color = Color.BLACK;
    private int hitCount = 0;

    public void adjustColor(Color color) {
        lock.writeLock().lock();

        try {
            if (hitCount == 0) {
                this.color = color;
            } else {
                this.color = new Color(
                    (this.color.getRed() + color.getRed()) / 2,
                    (this.color.getGreen() + color.getGreen()) / 2,
                    (this.color.getBlue() + color.getBlue()) / 2
                );
            }

            hitCount++;
        } finally {
            lock.writeLock().unlock();
        }
    }

    public Color getColor() {
        return color;
    }
}
