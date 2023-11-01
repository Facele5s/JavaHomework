package edu.project1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class WrongInputTest {
    @Test
    @DisplayName("Пустой ввод")
    void emptyInputTest() {
        String word = "Слово";
        String inp = "";

        ByteArrayInputStream inputStream = new ByteArrayInputStream(inp.getBytes());
        HangmanGame session = new HangmanGame();
        GameController gameController = new GameController(session, inputStream, null);

        String[] outputs = new String[]{" "};
        List<String> expectedResults = Arrays.asList(outputs);
        List<String> actualResults = gameController.testGame(word, inp, ObservingParams.WRONG_INPUT);

        assertEquals(expectedResults, actualResults);
    }

    @Test
    @DisplayName("Ввод больше, чем одной буквы")
    void manyCharsTest() {
        String word = "Слово";
        String inp = "абв";

        ByteArrayInputStream inputStream = new ByteArrayInputStream(inp.getBytes());
        HangmanGame session = new HangmanGame();
        GameController gameController = new GameController(session, inputStream, null);

        String[] outputs = new String[]{" "};
        List<String> expectedResults = Arrays.asList(outputs);
        List<String> actualResults = gameController.testGame(word, inp, ObservingParams.WRONG_INPUT);

        assertEquals(expectedResults, actualResults);
    }

    @Test
    @DisplayName("Ввод цифры")
    void digitInputTest() {
        String word = "Слово";
        String inp = "1\n2\n3";

        ByteArrayInputStream inputStream = new ByteArrayInputStream(inp.getBytes());
        HangmanGame session = new HangmanGame();
        GameController gameController = new GameController(session, inputStream, null);

        String[] outputs = new String[]{" ", " ", " "};
        List<String> expectedResults = Arrays.asList(outputs);
        List<String> actualResults = gameController.testGame(word, inp, ObservingParams.WRONG_INPUT);

        assertEquals(expectedResults, actualResults);
    }
}
