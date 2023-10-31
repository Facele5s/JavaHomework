package edu.project1;

import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class Main {
    private final static Logger LOGGER = LogManager.getLogger();

    private Main() {
    }

    public static void main(String[] args) {
        try {
            String filePath = "src/main/resources/GameWords.txt";
            Dictionary dictionary = new Dictionary(filePath);
            GameController gameController = new GameController(new HangmanGame(), System.in, dictionary);
            gameController.startGame();
        } catch (FileNotFoundException | WrongInputFormatException | NoSuchElementException e) {
            LOGGER.info(e.getMessage());
        }
    }
}
