package edu.project2.Exceptions;

public class WrongCellException extends Exception {
    public WrongCellException(int x, int y) {
        super(String.format("Невозможно получить доступ к ячейке [%d, %d]", x, y));
    }
}
