package edu.hw1;

import org.apache.logging.log4j.LogManager;

public class Task0 {
    private final static org.apache.logging.log4j.Logger LOGGER = LogManager.getLogger();

    public static void printHelloWorld() {
        LOGGER.info("Привет, мир!");
    }

    private Task0() {
    }
}
