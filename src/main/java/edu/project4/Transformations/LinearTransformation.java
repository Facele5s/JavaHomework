package edu.project4.Transformations;

import edu.project4.GeometryEntities.Point;

public class LinearTransformation implements Transformation {
    @Override
    public Point apply(Point point) {
        return new Point(point.x(), point.y());
    }
}
