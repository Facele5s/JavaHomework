package edu.project4.Transformations;

import edu.project4.GeometryEntities.Point;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@SuppressWarnings("MagicNumber")
public record AffineTransformation(double a, double b, double c, double d, double e, double f, Color color) {
    public Point applyAffine(Point point) {
        double newX = a * point.x() + b * point.y() + c;
        double newY = d * point.x() + e * point.y() + f;

        return new Point(newX, newY);
    }

    public static List<AffineTransformation> generateAffines(int nAffines) {
        Random random = new Random();
        List<AffineTransformation> affinesGenerated = new ArrayList<>();

        for (int i = 0; i < nAffines; i++) {
            double a;
            double b;
            double c = Math.random();
            double d;
            double e;
            double f = Math.random();

            do {
                a = Math.random() * 2 - 1;
                b = Math.random() * 2 - 1;
                d = Math.random() * 2 - 1;
                e = Math.random() * 2 - 1;
            } while (!checkAffineParams(a, b, d, e));

            int red = random.nextInt(256);
            int green = random.nextInt(256);
            int blue = random.nextInt(256);

            Color color = new Color(red, green, blue);

            AffineTransformation affine = new AffineTransformation(a, b, c, d, e, f, color);
            affinesGenerated.add(affine);
        }

        return affinesGenerated;
    }

    private static boolean checkAffineParams(double a, double b, double d, double e) {
        return (a * a + d * d < 1) && (b * b + e * e < 1)
            && (a * a + b * b + d * d + e * e < 1 + Math.pow((a * e - b * d), 2));
    }
}
