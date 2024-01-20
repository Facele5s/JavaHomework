package edu.project4;

import edu.project4.GeometryEntities.ImageCanvas;
import edu.project4.Transformations.LinearTransformation;
import edu.project4.Transformations.SphericalTransformation;
import edu.project4.Transformations.Transformation;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SpeedTest {
    private static final Logger LOGGER = LogManager.getLogger();

    @Test
    @DisplayName("Сравнение времени работы на разном количестве потоков")
    public void timeCompareTest() {
        FractalRenderer oneThreadRenderer = new FractalRenderer(1, 5);
        ImageCanvas canvas1 = new ImageCanvas(1000, 1000);
        List<Transformation> transformations = List.of(
            new SphericalTransformation(),
            new LinearTransformation()
        );

        long t1 = System.currentTimeMillis();
        oneThreadRenderer.render(canvas1, transformations, 1000000, 100);
        long t2 = System.currentTimeMillis();
        long time1 = t2 - t1;
        LOGGER.info("Время генерации фрактала при использовании 1 потока: " + (t2 - t1) / 1000 + "с");

        FractalRenderer sixThreadRenderer = new FractalRenderer(6, 5);
        ImageCanvas canvas2 = new ImageCanvas(1000, 1000);

        t1 = System.currentTimeMillis();
        sixThreadRenderer.render(canvas2, transformations, 1000000, 100);
        t2 = System.currentTimeMillis();
        long time2 = t2 - t1;
        LOGGER.info("Время генерации фрактала при использовании 6 потоков: " + (t2 - t1) / 1000 + "с");

        assertTrue(time2 < time1);
    }
}
