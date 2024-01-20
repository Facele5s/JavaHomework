package edu.project4.Transformations;

import edu.project4.GeometryEntities.Point;

@SuppressWarnings("MagicNumber")
public class PopcornTransformation implements Transformation {
    @Override
    public Point apply(Point point) {
        double c = Math.random();
        double f = Math.random();
        double newX = point.x() + c * Math.sin(Math.tan(3 * point.y()));
        double newY = point.y() + f * Math.sin(Math.tan(3 * point.x()));

        return new Point(newX, newY);
    }
}
