package edu.project4;

import edu.project4.GeometryEntities.ImageCanvas;
import edu.project4.GeometryEntities.Pixel;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class ImageProducer {
    private ImageProducer() {

    }

    public static void save(ImageCanvas canvas, File file) throws IOException {
        BufferedImage image = new BufferedImage(canvas.getWidth(), canvas.getHeight(), BufferedImage.TYPE_INT_RGB);
        Pixel[][] pixels = canvas.getPixels();

        for (int i = 0; i < canvas.getHeight(); i++) {
            for (int j = 0; j < canvas.getWidth(); j++) {
                image.setRGB(j, i, pixels[i][j].getColor().getRGB());
            }
        }

        ImageIO.write(image, "png", file);
    }
}
