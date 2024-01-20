package edu.project4.Transformations;

import edu.project4.GeometryEntities.Point;

public class SwirlTransformation implements Transformation {
    @Override
    public Point apply(Point point) {
        double r = Math.sqrt(Math.pow(point.x(), 2) + Math.pow(point.y(), 2));
        double newX = point.x() * Math.sin(r * r) - point.y() * Math.cos(r * r);
        double newY = point.x() * Math.cos(r * r) + point.y() * Math.sin(r * r);

        return new Point(newX, newY);
    }
}
