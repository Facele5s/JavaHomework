package edu.project1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class NumberOfAttemptsTest {
    @Test
    @DisplayName("Уменьшение количества попыток")
    void attemptsDecreaseTest() {
        String word = "Дерево";
        String inp = "а\nб\nг";

        ByteArrayInputStream inputStream = new ByteArrayInputStream(inp.getBytes());
        HangmanGame session = new HangmanGame();
        GameController gameController = new GameController(session, inputStream);

        String[] outputs = new String[]{"6", "5", "4"};
        List<String> expectedResults = Arrays.asList(outputs);
        List<String> actualResults = gameController.testGame(word, inp, ObservingParams.NUMBER_OF_ATTEMPTS);

        assertEquals(expectedResults, actualResults);
    }

    @Test
    @DisplayName("Постоянство количества попыток")
    void attemptsConstTest() {
        String word = "Тарелка";
        String inp = "т\nа\nр\nк";

        ByteArrayInputStream inputStream = new ByteArrayInputStream(inp.getBytes());
        HangmanGame session = new HangmanGame();
        GameController gameController = new GameController(session, inputStream);

        String[] outputs = new String[]{"7", "7", "7", "7"};
        List<String> expectedResults = Arrays.asList(outputs);
        List<String> actualResults = gameController.testGame(word, inp, ObservingParams.NUMBER_OF_ATTEMPTS);

        assertEquals(expectedResults, actualResults);
    }
}
