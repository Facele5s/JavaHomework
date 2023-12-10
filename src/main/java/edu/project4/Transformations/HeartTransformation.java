package edu.project4.Transformations;

import edu.project4.GeometryEntities.Point;

public class HeartTransformation implements Transformation {
    @Override
    public Point apply(Point point) {
        double r = Math.sqrt(Math.pow(point.x(), 2) + Math.pow(point.y(), 2));
        double theta = Math.atan2(point.x(), point.y());
        double newX = r * Math.sin(theta * r);
        double newY = -r * Math.cos(theta * r);
        return new Point(newX, newY);
    }
}
