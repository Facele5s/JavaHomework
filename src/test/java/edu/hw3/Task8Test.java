package edu.hw3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Task8Test {
    @Test
    @DisplayName("Проверка обратного итератора")
    public void backwardIteratorTest() {
        Iterator<Integer> backwardIterator = new BackwardIterator<>(List.of(5, 0, 1, 9));

        assertTrue(backwardIterator.hasNext());
        assertEquals(9, backwardIterator.next());

        assertTrue(backwardIterator.hasNext());
        assertEquals(1, backwardIterator.next());

        assertTrue(backwardIterator.hasNext());
        assertEquals(0, backwardIterator.next());

        assertTrue(backwardIterator.hasNext());
        assertEquals(5, backwardIterator.next());
    }

    @Test
    @DisplayName("Проверка пустым списком")
    public void emptyListTest() {
        Iterator<Integer> backwardIterator = new BackwardIterator<>(List.of());

        assertFalse(backwardIterator.hasNext());
        assertThrows(NoSuchElementException.class, backwardIterator::next);
    }
}
