package edu.hw6.Task1;

public class WrongFileFormatException extends Exception {
    public WrongFileFormatException() {
        super("Неверный формат заполнения файла");
    }
}
