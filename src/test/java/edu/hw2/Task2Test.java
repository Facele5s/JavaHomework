package edu.hw2;

import edu.hw2.Task2.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Task2Test {
    @Test
    @DisplayName("Площадь прямоугольника")
    public void rectangleAreaTest() {
        Rectangle rectangle = new Rectangle(2, 5);

        assertThat(rectangle.area()).isEqualTo(10);
    }

    @Test
    @DisplayName("Площадь квадрата")
    public void squareAreaTest() {
        Square square = new Square(10);

        assertThat(square.area()).isEqualTo(100);
    }

    @Test
    @DisplayName("Площадь прямоугольника после изменения сторон")
    public void rectangleAreaChangeSidesTest() {
        Rectangle rectangle = new Rectangle(14, 6);
        assertThat(rectangle.area()).isEqualTo(84);

        rectangle = rectangle.setWidth(15);
        rectangle = rectangle.setHeight(9);
        assertThat(rectangle.area()).isEqualTo(135);
    }

    @Test
    @DisplayName("Площадь квадрата после изменения ширины")
    public void squareAreaChangeWidthTest() {
        Rectangle square = new Square(8);
        assertThat(square.area()).isEqualTo(64);

        square = square.setWidth(9);
        assertThat(square.area()).isEqualTo(81);
    }

    @Test
    @DisplayName("Площадь квадрата после изменения высоты")
    public void squareAreaChangeHeightTest() {
        Rectangle square = new Square(5);
        assertThat(square.area()).isEqualTo(25);

        square = square.setHeight(11);
        assertThat(square.area()).isEqualTo(121);
    }
}
