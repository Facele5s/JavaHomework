package edu.project4.Transformations;

import edu.project4.GeometryEntities.Point;
import static java.lang.Math.PI;

public class DiskTransformation implements Transformation {
    @Override
    public Point apply(Point point) {
        double r = Math.sqrt(Math.pow(point.x(), 2) + Math.pow(point.y(), 2));
        double yDivX = point.y() / point.x();
        double newX = Math.atan(yDivX) * Math.sin(PI * r) / PI;
        double newY = Math.atan(yDivX) * Math.cos(PI * r) / PI;

        return new Point(newX, newY);
    }
}
