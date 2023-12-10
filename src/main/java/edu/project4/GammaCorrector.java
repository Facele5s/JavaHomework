package edu.project4;

import edu.project4.GeometryEntities.ImageCanvas;
import edu.project4.GeometryEntities.Pixel;
import java.awt.Color;

public class GammaCorrector {
    private static final double GAMMA = 1.4;

    private GammaCorrector() {

    }

    public static void correctGamma(ImageCanvas canvas) {
        if (canvas == null) {
            throw new IllegalArgumentException("Передан null");
        }

        setPixelGamma(canvas);

        double maxGamma = getMaxGamma(canvas);

        applyToCanvas(canvas, maxGamma);
    }

    private static void setPixelGamma(ImageCanvas canvas) {
        Pixel[][] pixels = canvas.getPixels();

        for (int i = 0; i < canvas.getHeight(); i++) {
            for (int j = 0; j < canvas.getWidth(); j++) {
                Pixel pixel = pixels[i][j];

                if (pixel.getHitCount() != 0) {
                    pixel.setNormal(Math.log10(pixel.getHitCount()));
                }
            }
        }
    }

    private static double getMaxGamma(ImageCanvas canvas) {
        Pixel[][] pixels = canvas.getPixels();
        double maxGamma = Double.MIN_VALUE;

        for (int i = 0; i < canvas.getHeight(); i++) {
            for (int j = 0; j < canvas.getWidth(); j++) {
                Pixel pixel = pixels[i][j];

                if (pixel.getHitCount() != 0) {
                    maxGamma = Math.max(maxGamma, pixel.getNormal());
                }
            }
        }

        return maxGamma;
    }

    private static void applyToCanvas(ImageCanvas canvas, double maxGamma) {
        Pixel[][] pixels = canvas.getPixels();

        for (int i = 0; i < canvas.getHeight(); i++) {
            for (int j = 0; j < canvas.getWidth(); j++) {
                Pixel pixel = pixels[i][j];

                applyToPixel(pixel, maxGamma);
            }
        }
    }

    private static void applyToPixel(Pixel pixel, double maxGamma) {
        pixel.setNormal(pixel.getNormal() / maxGamma);
        double k = Math.pow(pixel.getNormal(), (1 / GAMMA));

        int r = (int) (pixel.getColor().getRed() * k);
        int g = (int) (pixel.getColor().getGreen() * k);
        int b = (int) (pixel.getColor().getBlue() * k);

        pixel.setColor(new Color(r, g, b));
    }
}
