package edu.project4.Transformations;

import edu.project4.GeometryEntities.Point;
import java.awt.Color;

public record AffineTransformation(double a, double b, double c, double d, double e, double f, Color color) {
    public Point applyAffine(Point point) {
        double newX = a * point.x() + b * point.y() + c;
        double newY = d * point.x() + e * point.y() + f;

        return new Point(newX, newY);
    }
}
