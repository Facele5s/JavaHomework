package edu.project4;

import edu.project4.GeometryEntities.ImageCanvas;
import edu.project4.Transformations.PopcornTransformation;
import edu.project4.Transformations.SwirlTransformation;
import edu.project4.Transformations.Transformation;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        File file = new File("src/main/java/edu/project4/imggg.png");
        FractalRenderer renderer = new FractalRenderer(6, 5);
        ImageCanvas canvas = new ImageCanvas(1000, 1000);
        List<Transformation> transformations = List.of(
            new PopcornTransformation(),
            new SwirlTransformation()
        );

        renderer.render(canvas, transformations, 100000, 20);
        ImageProducer.save(canvas, file);
    }
}
