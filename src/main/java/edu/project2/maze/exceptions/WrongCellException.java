package edu.project2.maze.exceptions;

public class WrongCellException extends Exception {
    public WrongCellException(int x, int y) {
        super(String.format("Невозможно получить доступ к ячейке [%d, %d]", x, y));
    }
}
