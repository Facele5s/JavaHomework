package edu.hw5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static edu.hw5.Task5.validateRusNumber;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Task5Test {
    @Test
    @DisplayName("Проверка российского номера")
    public void rusNumberCheck() {
        assertTrue(validateRusNumber("Г111ГГ111"));
        assertTrue(validateRusNumber("А123БВ456"));
        assertTrue(validateRusNumber("А123ВЕ777"));
        assertTrue(validateRusNumber("О777ОО177"));

        assertFalse(validateRusNumber("12346"));
        assertFalse(validateRusNumber("Q123RW315"));
        assertFalse(validateRusNumber("123АВЕ777"));
        assertFalse(validateRusNumber("А123ВГ77"));
        assertFalse(validateRusNumber("А123ВЕ7777"));

        assertFalse(validateRusNumber(""));
    }

    @Test
    @DisplayName("Проверка на null")
    public void nullTest() {
        assertFalse(validateRusNumber(null));
    }
}
