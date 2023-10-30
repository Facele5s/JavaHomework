package edu.hw2;

public class Task2 {
    private Task2() {
    }

    public static class Rectangle {
        private final int width;
        private final int height;

        public Rectangle(int width, int height) {
            this.width = width;
            this.height = height;
        }

        public Rectangle setWidth(int width) {
            return new Rectangle(width, this.height);
        }

        public Rectangle setHeight(int height) {
            return new Rectangle(this.width, height);
        }

        public double area() {
            return width * height;
        }
    }

    public static class Square extends Rectangle {
        public Square(int side) {
            super(side, side);
        }

        @Override
        public Rectangle setWidth(int side) {
            return new Square(side);
        }

        @Override
        public Rectangle setHeight(int side) {
            return new Square(side);
        }
    }
}
