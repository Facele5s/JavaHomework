package edu.project1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class NumberOfSymbolsTest {
    @Test
    @DisplayName("Уменьшение количества оставшихся символов")
    void remainingCharsDecrTest() {
        String word = "Сила";
        String inp = "С\nи\nл\nа";

        ByteArrayInputStream inputStream = new ByteArrayInputStream(inp.getBytes());
        HangmanGame session = new HangmanGame();
        GameController gameController = new GameController(session, inputStream, null);

        String[] outputs = new String[]{"3", "2", "1", "0"};
        List<String> expectedResults = Arrays.asList(outputs);
        List<String> actualResults = gameController.testGame(word, inp, ObservingParams.NUMBER_OF_REMAINING_CHARS);

        assertEquals(expectedResults, actualResults);
    }

    @Test
    @DisplayName("Постоянство количества оставшихся символов")
    void remainingCharsConstTest() {
        String word = "Сила";
        String inp = "К\nо\nн\nь";

        ByteArrayInputStream inputStream = new ByteArrayInputStream(inp.getBytes());
        HangmanGame session = new HangmanGame();
        GameController gameController = new GameController(session, inputStream, null);

        String[] outputs = new String[]{"4", "4", "4", "4"};
        List<String> expectedResults = Arrays.asList(outputs);
        List<String> actualResults = gameController.testGame(word, inp, ObservingParams.NUMBER_OF_REMAINING_CHARS);

        assertEquals(expectedResults, actualResults);
    }

    @Test
    @DisplayName("Пополнение списка использованных символов")
    void usedCharsIncreaseTest() {
        String word = "Нога";
        String inp = "Н\nо\nг\nа";

        ByteArrayInputStream inputStream = new ByteArrayInputStream(inp.getBytes());
        HangmanGame session = new HangmanGame();
        GameController gameController = new GameController(session, inputStream, null);

        String[] outputs = new String[]{"[Н]", "[Н, О]", "[Г, Н, О]", "[А, Г, Н, О]",};
        List<String> expectedResults = Arrays.asList(outputs);
        List<String> actualResults = gameController.testGame(word, inp, ObservingParams.USED_SYMBOLS);

        assertEquals(expectedResults, actualResults);
    }

    @Test
    @DisplayName("Использование одинаковых символов")
    void usedCharsTest() {
        String word = "Нога";
        String inp = "Н\nн\nн\nн";

        ByteArrayInputStream inputStream = new ByteArrayInputStream(inp.getBytes());
        HangmanGame session = new HangmanGame();
        GameController gameController = new GameController(session, inputStream, null);

        String[] outputs = new String[]{"[Н]", "[Н]", "[Н]", "[Н]"};
        List<String> expectedResults = Arrays.asList(outputs);
        List<String> actualResults = gameController.testGame(word, inp, ObservingParams.USED_SYMBOLS);

        assertEquals(expectedResults, actualResults);
    }
}
