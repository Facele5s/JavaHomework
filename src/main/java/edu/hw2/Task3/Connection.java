package edu.hw2.Task3;

public interface Connection extends AutoCloseable {
    String SUCCESS = ": команда выполнена успешно!";
    String CLOSED = ": соединение закрыто.";
    String ERROR = "Ошибка подключения";

    void execute(String command);
}
