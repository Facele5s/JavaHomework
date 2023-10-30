package edu.project1;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class GameController implements GameControls {
    private final HangmanGame session;
    private final static Logger LOGGER = LogManager.getLogger();
    private Scanner sc;
    private InputStream inputStream;

    private final String commandSTOP = "/stop";
    private final String commandYES = "/yes";
    private final String commandNO = "/no";
    private final String startNewGame = "Начать новую игру? (Да/Нет)";
    private final String typeOneLetter = "Введите только одну букву:";

    public GameController(HangmanGame session, InputStream inputStream) {
        this.session = session;
        this.inputStream = inputStream;
    }

    @Override
    public void startGame() {
        sc = new Scanner(System.in);

        session.setWord(Dictionary.getGameWord());
        session.initSession();

        LOGGER.info("Игра началась!");
        LOGGER.info("Чтобы сдаться введите команду /stop \n");
        LOGGER.info("Вам было загадано слово из " + session.getWord().length() + " букв.");
        LOGGER.info("Попробуйте отгадать его.");

        playGame();
    }

    @Override
    public void playGame() {
        session.setGameState(GameStates.GAME_PROCESS);

        while (session.getGameState() == GameStates.GAME_PROCESS) {
            LOGGER.info("Введите букву:");
            String inputString = readInput();

            if (!inputString.equalsIgnoreCase(commandSTOP)) {
                makeAttempt(inputString.charAt(0));
            } else {
                stopGame();
            }
        }
    }

    @Override
    public List<String> testGame(String word, String inputs, ObservingParams param) {
        List<String> response = new ArrayList<>();
        session.setGameState(GameStates.GAME_PROCESS);
        session.setWord(word);
        session.initSession();
        inputStream = new ByteArrayInputStream(inputs.getBytes());
        sc = new Scanner(inputStream);

        for (int i = 0; i < inputs.split("\n").length; i++) {
            String inputString = readInput();

            if (!inputString.equalsIgnoreCase(commandSTOP)) {
                makeAttempt(inputString.charAt(0));
            } else {
                stopGame();
            }

            switch (param) {
                case CURRENT_WORD_STATE: {
                    response.add(Arrays.toString(session.getHiddenSymbols()));
                    break;
                }
                case NUMBER_OF_ATTEMPTS: {
                    response.add(Integer.toString(session.getNumberOfAttempts()));
                    break;
                }
                case NUMBER_OF_REMAINING_CHARS: {
                    response.add(Integer.toString(session.getNumberOfRemainingChars()));
                    break;
                }
                case USED_SYMBOLS: {
                    response.add(session.getUsedChars().toString());
                    break;
                }
                case GAME_STATE: {
                    response.add(session.getGameState().toString());
                    break;
                }
                case WRONG_INPUT: {
                    response.add(" ");
                    break;
                }
                default: {
                    break;
                }
            }
        }

        stopGame();
        return response;
    }

    @Override
    public void stopGame() {
        session.setGameState(GameStates.STOP);

        LOGGER.info("Игра остановлена");
    }

    @Override
    public void winGame() {
        session.setGameState(GameStates.WAITING);

        LOGGER.info("Вы выиграли! Было загадано слово " + session.getWord());
        LOGGER.info(startNewGame);

        if (sc.hasNextLine()) {
            String inputString = readInput();

            switch (inputString) {
                case commandYES: {
                    startGame();
                    break;
                }
                case commandSTOP, commandNO: {
                    stopGame();
                    break;
                }
                default: {
                    break;
                }
            }
        }
    }

    @Override
    public void loseGame() {
        session.setGameState(GameStates.WAITING);

        LOGGER.info("Вы проиграли! Было загадано слово " + session.getWord());
        LOGGER.info(startNewGame);

        if (sc.hasNextLine()) {
            String inputString = readInput();

            switch (inputString) {
                case commandYES: {
                    startGame();
                    break;
                }
                case commandSTOP, commandNO: {
                    stopGame();
                    break;
                }
                default: {
                    break;
                }
            }
        }
    }

    @Override
    public void makeAttempt(char attempt) {
        if (session.getGameState() == GameStates.GAME_PROCESS) {
            if (session.isCharUsed(attempt)) {
                LOGGER.info("Буква уже была. Попробуйте другую:");
                return;
            }

            if (session.wordContainsChar(attempt)) {
                if (session.getNumberOfRemainingChars() == 0) {
                    winGame();
                } else {
                    LOGGER.info("Вы угадали!");
                }
            } else {
                LOGGER.info("Вы не угадали! Осталось попыток: " + session.getNumberOfAttempts());
                if (session.getNumberOfAttempts() == 0) {
                    loseGame();
                }
            }

            if (session.getGameState() == GameStates.GAME_PROCESS) {
                LOGGER.info("Слово: " + new String(session.getHiddenSymbols()));
            }
        }
    }

    @Override
    public String readInput() {
        String str;

        while (sc.hasNextLine()) {
            str = sc.nextLine();

            if (str.isEmpty() || str.equalsIgnoreCase(commandSTOP)) {
                break;
            } else if (str.equalsIgnoreCase("да")) {
                if (session.getGameState() == GameStates.WAITING) {
                    return commandYES;
                } else {
                    LOGGER.info(typeOneLetter);
                }
            } else if (str.equalsIgnoreCase("нет")) {
                if (session.getGameState() == GameStates.WAITING) {
                    return commandNO;
                } else {
                    LOGGER.info(typeOneLetter);
                }
            } else if (str.length() > 1) {
                LOGGER.info(typeOneLetter);
            } else if (!Character.isLetter(str.charAt(0))) {
                LOGGER.info("Введённый вами символ не является буквой.");
            } else {
                return str;
            }
        }

        return commandSTOP;
    }
}
