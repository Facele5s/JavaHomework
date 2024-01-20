package edu.project4;

import edu.project4.GeometryEntities.ImageCanvas;
import edu.project4.GeometryEntities.Pixel;
import edu.project4.GeometryEntities.Point;
import edu.project4.Transformations.AffineTransformation;
import edu.project4.Transformations.Transformation;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@SuppressWarnings("MagicNumber")
public class FractalRenderer {
    private static final Random RANDOM = new Random();

    private final ExecutorService executor;
    private final int nThreads;
    private final List<AffineTransformation> affines;

    public FractalRenderer(int nThreads, int nAffines) {
        if (nThreads < 1) {
            throw new IllegalArgumentException("Указано отрицательное число потоков");
        }
        if (nAffines < 1) {
            throw new IllegalArgumentException("Указано отрицательное число афинных преобразований");
        }

        this.nThreads = nThreads;
        this.executor = Executors.newFixedThreadPool(this.nThreads);
        this.affines = AffineTransformation.generateAffines(nAffines);
    }

    public void render(
        ImageCanvas canvas, List<Transformation> transformations,
        int nSamples, int iterationsPerSample
    ) {
        if (transformations == null || transformations.isEmpty()) {
            throw new IllegalArgumentException("Передан пустой список нелинейных преобразований");
        }
        if (nSamples < 0) {
            throw new IllegalArgumentException("Передано отрицательное число образцов");
        }
        if (iterationsPerSample < 0) {
            throw new IllegalArgumentException("Передано отрицательное число итераций");
        }

        int samplesPerThread = nSamples / nThreads;

        int xMax = 1;
        int yMax = 1;

        executor.execute(() -> {
            for (int i = 0; i < samplesPerThread; i++) {
                Point randomPoint = canvas.pickRandomPoint(xMax, yMax);

                for (int j = -20; j < iterationsPerSample; j++) {
                    AffineTransformation affine = affines.get(RANDOM.nextInt(affines.size()));

                    Point transformedPoint = affine.applyAffine(randomPoint);
                    for (Transformation transformation : transformations) {
                        transformedPoint = transformation.apply(transformedPoint);
                    }

                    if (j >= 0 && Math.abs(transformedPoint.x()) <= xMax
                        && Math.abs(transformedPoint.y()) <= yMax) {
                        int pixelX = canvas.getHeight()
                            - (int) (((xMax - transformedPoint.x()) / (2 * xMax)) * canvas.getHeight());
                        int pixelY = canvas.getWidth()
                            - (int) (((yMax - transformedPoint.y()) / (2 * yMax)) * canvas.getWidth());

                        if (pixelX >= 0 && pixelX < canvas.getWidth()
                            && pixelY >= 0 && pixelY < canvas.getWidth()) {
                            Pixel[][] pixels = canvas.getPixels();
                            pixels[pixelY][pixelX].adjustColor(affine.color());
                        }
                    }
                }
            }
        });

        executor.close();
    }

    /*private List<AffineTransformation> generateAffines(int nAffines) {
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

            int red = RANDOM.nextInt(256);
            int green = RANDOM.nextInt(256);
            int blue = RANDOM.nextInt(256);

            Color color = new Color(red, green, blue);

            AffineTransformation affine = new AffineTransformation(a, b, c, d, e, f, color);
            affinesGenerated.add(affine);
        }

        return affinesGenerated;
    }

    private boolean checkAffineParams(double a, double b, double d, double e) {
        return (a * a + d * d < 1) && (b * b + e * e < 1)
            && (a * a + b * b + d * d + e * e < 1 + Math.pow((a * e - b * d), 2));
    }*/

}
