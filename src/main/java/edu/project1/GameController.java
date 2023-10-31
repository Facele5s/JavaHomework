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
    private final static Logger LOGGER = LogManager.getLogger();
    private static final String COMMAND_STOP = "/stop";
    private static final String COMMAND_YES = "/yes";
    private static final String COMMAND_NO = "/no";
    private static final String START_NEW_GAME = "Начать новую игру? (Да/Нет)";
    private static final String TYPE_ONE_LETTER = "Введите только одну букву:";

    private final Dictionary dictionary;
    private final HangmanGame session;
    private Scanner scanner;
    private InputStream inputStream;

    public GameController(HangmanGame session, InputStream inputStream, Dictionary dictionary) {
        this.session = session;
        this.inputStream = inputStream;
        this.dictionary = dictionary;
    }

    @Override
    public void startGame() {
        scanner = new Scanner(System.in);

        session.setWord(dictionary.getGameWord());
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

            if (!inputString.equalsIgnoreCase(COMMAND_STOP)) {
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
        scanner = new Scanner(inputStream);

        for (int i = 0; i < inputs.split("\n").length; i++) {
            String inputString = readInput();

            if (!inputString.equalsIgnoreCase(COMMAND_STOP)) {
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
        LOGGER.info(START_NEW_GAME);

        if (scanner.hasNextLine()) {
            String inputString = readInput();

            switch (inputString) {
                case COMMAND_YES: {
                    startGame();
                    break;
                }
                case COMMAND_STOP, COMMAND_NO: {
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
        LOGGER.info(START_NEW_GAME);

        if (scanner.hasNextLine()) {
            String inputString = readInput();

            switch (inputString) {
                case COMMAND_YES: {
                    startGame();
                    break;
                }
                case COMMAND_STOP, COMMAND_NO: {
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

        while (scanner.hasNextLine()) {
            str = scanner.nextLine();

            if (str.isEmpty() || str.equalsIgnoreCase(COMMAND_STOP)) {
                break;
            } else if (str.equalsIgnoreCase("да")) {

                if (session.getGameState() == GameStates.WAITING) {
                    return COMMAND_YES;
                }
                LOGGER.info(TYPE_ONE_LETTER);

            } else if (str.equalsIgnoreCase("нет")) {

                if (session.getGameState() == GameStates.WAITING) {
                    return COMMAND_NO;
                }
                LOGGER.info(TYPE_ONE_LETTER);

            } else if (str.length() > 1) {
                LOGGER.info(TYPE_ONE_LETTER);
            } else if (!Character.isLetter(str.charAt(0))) {
                LOGGER.info("Введённый вами символ не является буквой.");
            } else {
                return str;
            }
        }

        return COMMAND_STOP;
    }
}
