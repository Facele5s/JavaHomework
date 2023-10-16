package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static edu.hw1.Task4.fixString;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task4Test {
    @Test
    @DisplayName("Проверка работоспособности алгоритма")
    public void testCorrect() {
        //Входные данные: "123456"
        //Ожидаемый результат: "214365"
        String actual = fixString("123456");
        String expected = "214365";
        assertEquals(expected, actual);

        //Входные данные: "hTsii  s aimex dpus rtni."
        //Ожидаемый результат: "This is a mixed up string."
        actual = fixString("hTsii  s aimex dpus rtni.g");
        expected = "This is a mixed up string.";
        assertEquals(expected, actual);

        //Входные данные: "badce"
        //Ожидаемый результат: "abcde"
        actual = fixString("badce");
        expected = "abcde";
        assertEquals(expected, actual);

        //Входные данные: "hTsii  symv ioec"
        //Ожидаемый результат: "This is my voice"
        actual = fixString("hTsii  symv ioec");
        expected = "This is my voice";
        assertEquals(expected, actual);

        //Входные данные: "hT eoLdrO  fhT eiRgns"
        //Ожидаемый результат: "The Lord Of The Rings"
        actual = fixString("hT eoLdrO  fhT eiRgns");
        expected = "The Lord Of The Rings";
        assertEquals(expected, actual);

        //Входные данные: "1a2b3c"
        //Ожидаемый результат: "a1b2c3"
        actual = fixString("1a2b3c");
        expected = "a1b2c3";
        assertEquals(expected, actual);

        //Входные данные: "a1b2c3"
        //Ожидаемый результат: "1a2b3c"
        actual = fixString("a1b2c3");
        expected = "1a2b3c";
        assertEquals(expected, actual);

        //Входные данные: "A"
        //Ожидаемый результат: "A"
        actual = fixString("A");
        expected = "A";
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Проверка на пустую строку")
    public void testEmptyString() {
        //Входные данные: ""
        //Ожидаемый результат: ""
        String actual = fixString("");
        String expected = "";
        assertEquals(expected, actual);
    }

}
