package edu.hw5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static edu.hw5.Task4.validateStrongPassword;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Task4Test {
    @Test
    @DisplayName("Проверка надёжности пароля")
    public void validPasswordTest() {
        assertTrue(validateStrongPassword("~"));
        assertTrue(validateStrongPassword("!"));
        assertTrue(validateStrongPassword("@"));
        assertTrue(validateStrongPassword("#"));
        assertTrue(validateStrongPassword("$"));
        assertTrue(validateStrongPassword("%"));
        assertTrue(validateStrongPassword("^"));
        assertTrue(validateStrongPassword("&"));
        assertTrue(validateStrongPassword("*"));
        assertTrue(validateStrongPassword("|"));
        assertTrue(validateStrongPassword("ULTRASTRONG PASSWORD!!!!"));
        assertTrue(validateStrongPassword("12$323^4654!4"));

        assertFalse(validateStrongPassword("VERYSTRONG PASSWORD"));
        assertFalse(validateStrongPassword("1232346544"));
        assertTrue(validateStrongPassword("12$323^4654!4"));

        assertFalse(validateStrongPassword(""));
    }

    @Test
    @DisplayName("Проверка на null")
    public void nullTest() {
        assertFalse(validateStrongPassword(null));
    }
}
