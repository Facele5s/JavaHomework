package edu.project4.Transformations;

import edu.project4.GeometryEntities.Point;

public class HorseshoeTransformation implements Transformation {
    @Override
    public Point apply(Point point) {
        double r = Math.sqrt(Math.pow(point.x(), 2) + Math.pow(point.y(), 2));
        double newX = (Math.pow(point.x(), 2) - Math.pow(point.y(), 2)) / r;
        double newY = 2 * point.x() * point.y();

        return new Point(newX, newY);
    }
}
