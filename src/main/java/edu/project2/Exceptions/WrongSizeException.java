package edu.project2.Exceptions;

public class WrongSizeException extends Exception {
    public WrongSizeException(int width, int height) {
        super(String.format("Невозможно создать лабиринт c размерами [%dx%d]",
            width, height
        ));
    }
}
