package edu.project4;

import edu.project4.GeometryEntities.ImageCanvas;
import edu.project4.Transformations.HeartTransformation;
import edu.project4.Transformations.Transformation;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ImageSavingTest {
    private static final File file = new File("src/main/java/edu/project4/saveTest.png");

    @Test
    @DisplayName("Сохранение изображения фрактала")
    public void fractalSaveTest() {
        if (file.exists()) {
            file.delete();
        }

        FractalRenderer renderer = new FractalRenderer(6, 5);
        ImageCanvas canvas = new ImageCanvas(1000, 1000);
        List<Transformation> transformations = List.of(
            new HeartTransformation()
        );

        renderer.render(canvas, transformations, 100000, 20);

        try {
            ImageProducer.save(canvas, file);

            assertTrue(file.exists());

            assertTrue(Files.size(file.toPath()) > 0);

            BufferedImage image = ImageIO.read(file);
            assertEquals(1000, image.getWidth());
            assertEquals(1000, image.getHeight());
        } catch (IOException e) {
            fail();
        }

        file.delete();
    }
}
