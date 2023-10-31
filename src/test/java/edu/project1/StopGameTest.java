package edu.project1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class StopGameTest {
    @Test
    @DisplayName("Остановка игры в начале")
    void stopGameOnStartTest() {
        String word = "Слово";
        String inp = "/stop";

        ByteArrayInputStream inputStream = new ByteArrayInputStream(inp.getBytes());
        HangmanGame session = new HangmanGame();
        GameController gameController = new GameController(session, inputStream, null);

        String[] outputs = new String[]{"STOP"};
        List<String> expectedResults = Arrays.asList(outputs);
        List<String> actualResults = gameController.testGame(word, inp, ObservingParams.GAME_STATE);

        assertEquals(expectedResults, actualResults);
    }

    @Test
    @DisplayName("Остановка игры в конце")
    void stopGameOnEndTest() {
        String word = "Кот";
        String inp = "К\nо\nт\n/stop";

        ByteArrayInputStream inputStream = new ByteArrayInputStream(inp.getBytes());
        HangmanGame session = new HangmanGame();
        GameController gameController = new GameController(session, inputStream, null);

        String[] outputs = new String[]{"GAME_PROCESS", "GAME_PROCESS", "STOP", "STOP"};
        List<String> expectedResults = Arrays.asList(outputs);
        List<String> actualResults = gameController.testGame(word, inp, ObservingParams.GAME_STATE);

        assertEquals(expectedResults, actualResults);
    }
}
