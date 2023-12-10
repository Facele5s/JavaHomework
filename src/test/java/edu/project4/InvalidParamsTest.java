package edu.project4;

import edu.project4.GeometryEntities.ImageCanvas;
import edu.project4.Transformations.LinearTransformation;
import edu.project4.Transformations.Transformation;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class InvalidParamsTest {
    @Test
    @DisplayName("Проверка на невалидные параметры")
    public void invalidParamsTest() {
        FractalRenderer renderer = new FractalRenderer(6, 5);
        try {
            FractalRenderer renderer1 = new FractalRenderer(-1, 0);
        } catch (IllegalArgumentException e) {
            assertTrue(true);
        }

        ImageCanvas canvas = new ImageCanvas(1000, 1000);
        try {
            ImageCanvas canvas1 = new ImageCanvas(0, 0);
        } catch (IllegalArgumentException e) {
            assertTrue(true);
        }

        List<Transformation> transformations = List.of(new LinearTransformation());

        try {
            renderer.render(canvas, null, 100000, 20);
        } catch (IllegalArgumentException e) {
            assertTrue(true);
        }

        try {
            renderer.render(canvas, transformations, -1, 20);
        } catch (IllegalArgumentException e) {
            assertTrue(true);
        }

        try {
            renderer.render(canvas, transformations, 100000, -1);
        } catch (IllegalArgumentException e) {
            assertTrue(true);
        }
    }
}
