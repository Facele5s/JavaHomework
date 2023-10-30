package edu.project1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameScenariosTest {
    @Test
    @DisplayName("Игровой сценарий \"Безупречная победа\"")
    void flawlessVictoryTest() {
        String word = "Клён";
        String inp = "К\nл\nё\nн";

        ByteArrayInputStream inputStream = new ByteArrayInputStream(inp.getBytes());
        HangmanGame session = new HangmanGame();
        GameController gameController = new GameController(session, inputStream);

        String[] outputs = new String[]{"[К, *, *, *]", "[К, л, *, *]", "[К, л, ё, *]",
            "[К, л, ё, н]"};
        List<String> expectedResults = Arrays.asList(outputs);
        List<String> actualResults = gameController.testGame(word, inp, ObservingParams.CURRENT_WORD_STATE);

        assertEquals(expectedResults, actualResults);
    }

    @Test
    @DisplayName("Игровой сценарий \"Полное поражение\"")
    void completeDefeatTest() {
        String word = "Собака";
        String inp = "й\nц\nу\nе\nн\nг\nш";

        ByteArrayInputStream inputStream = new ByteArrayInputStream(inp.getBytes());
        HangmanGame session = new HangmanGame();
        GameController gameController = new GameController(session, inputStream);

        String[] outputs = new String[]{"[*, *, *, *, *, *]", "[*, *, *, *, *, *]",
            "[*, *, *, *, *, *]", "[*, *, *, *, *, *]", "[*, *, *, *, *, *]",
            "[*, *, *, *, *, *]", "[*, *, *, *, *, *]"};
        List<String> expectedResults = Arrays.asList(outputs);
        List<String> actualResults = gameController.testGame(word, inp, ObservingParams.CURRENT_WORD_STATE);

        assertEquals(expectedResults, actualResults);
    }

    @Test
    @DisplayName("Игровой сценарий \"Победа с промахами\"")
    void victoryWithMistakesTest() {
        String word = "Зефир";
        String inp = "з\nр\nн\nг\nе\nх\nф\nи";

        ByteArrayInputStream inputStream = new ByteArrayInputStream(inp.getBytes());
        HangmanGame session = new HangmanGame();
        GameController gameController = new GameController(session, inputStream);

        String[] outputs = new String[]{"[З, *, *, *, *]", "[З, *, *, *, р]",
            "[З, *, *, *, р]", "[З, *, *, *, р]", "[З, е, *, *, р]",
            "[З, е, *, *, р]", "[З, е, ф, *, р]", "[З, е, ф, и, р]"};
        List<String> expectedResults = Arrays.asList(outputs);
        List<String> actualResults = gameController.testGame(word, inp, ObservingParams.CURRENT_WORD_STATE);

        assertEquals(expectedResults, actualResults);
    }
}
