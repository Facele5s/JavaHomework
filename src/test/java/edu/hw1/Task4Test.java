package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static edu.hw1.Task4.fixString;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task4Test {
    @Test
    @DisplayName("Правильность результата")
    public void testCorrect() {
        String actual = fixString("123456");
        String expected = "214365";
        assertEquals(expected, actual);

        actual = fixString("hTsii  s aimex dpus rtni.g");
        expected = "This is a mixed up string.";
        assertEquals(expected, actual);

        actual = fixString("badce");
        expected = "abcde";
        assertEquals(expected, actual);

        actual = fixString("hTsii  symv ioec");
        expected = "This is my voice";
        assertEquals(expected, actual);

        actual = fixString("hT eoLdrO  fhT eiRgns");
        expected = "The Lord Of The Rings";
        assertEquals(expected, actual);

        actual = fixString("1a2b3c");
        expected = "a1b2c3";
        assertEquals(expected, actual);

        actual = fixString("a1b2c3");
        expected = "1a2b3c";
        assertEquals(expected, actual);

        actual = fixString("A");
        expected = "A";
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Проверка на пустую строку")
    public void testEmpty() {
        String actual = fixString("");
        String expected = "";
        assertEquals(expected, actual);
    }

}
