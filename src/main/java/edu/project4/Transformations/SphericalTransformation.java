package edu.project4.Transformations;

import edu.project4.GeometryEntities.Point;

public class SphericalTransformation implements Transformation {
    @Override
    public Point apply(Point point) {
        double r = Math.sqrt(Math.pow(point.x(), 2) + Math.pow(point.y(), 2));
        double newX = point.x() / Math.pow(r, 2);
        double newY = point.y() / Math.pow(r, 2);

        return new Point(newX, newY);
    }
}
