package edu.hw7;

import edu.hw7.Task3.Person;
import edu.hw7.Task3.RWLockDatabase;
import edu.hw7.Task3.SynchronizedDatabase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

public class Task3Test {
    private static final Person PERSON_1 = new Person(1, "Edward", "Адрес 1", "123");
    private static final Person PERSON_2 = new Person(2, "Edward", "Адрес 2", "456");
    private static final Person PERSON_3 = new Person(3, "Robert", "Адрес 3", "789");
    private static final Person PERSON_4 = new Person(4, "Susie", "Адрес 3", "101");
    private static final Person PERSON_5 = new Person(5, "Ben", "Адрес 4", "112");
    private static final Person PERSON_6 = new Person(6, "Elza", "Адрес 5", "131");

    private static final Set<Person> allPersons =
        new HashSet<>(Set.of(PERSON_1, PERSON_2, PERSON_3, PERSON_4, PERSON_5, PERSON_6));

    @Test
    @DisplayName("Проверка на заполнение всех полей")
    public void allFieldsFilledCheck() {
        try {
            new Person(1, "Rem", "Address", "Phone");
            assertTrue(true);
        } catch (Exception e) {
            fail();
        }

        try {
            new Person(-1, "Name", "Address", "Phone");
        } catch (Exception e) {
            assertTrue(e instanceof IllegalArgumentException);
        }

        try {
            new Person(1, "", "Address", "Phone");
        } catch (Exception e) {
            assertTrue(e instanceof IllegalArgumentException);
        }

        try {
            new Person(1, "Name", null, "Phone");
        } catch (Exception e) {
            assertTrue(e instanceof IllegalArgumentException);
        }
    }

    @Test
    @DisplayName("Проверка операций базы данных с синхронизацией")
    public void synchronizedDatabaseTest() {
        SynchronizedDatabase database = new SynchronizedDatabase();

        database.add(PERSON_1);
        database.add(PERSON_1);
        database.add(PERSON_2);
        database.add(PERSON_3);
        database.add(PERSON_4);
        database.add(PERSON_5);
        database.add(PERSON_6);

        assertEquals(database.getAll(), allPersons);

        assertEquals(database.findById(1), PERSON_1);
        assertEquals(database.findById(6), PERSON_6);
        assertNotEquals(database.findById(2), PERSON_4);
        assertNull(database.findById(-1));

        assertEquals(database.findByName("Edward"), List.of(PERSON_1, PERSON_2));
        assertNull(database.findByName("Stan"));

        assertEquals(database.findByAddress("Адрес 3"), List.of(PERSON_3, PERSON_4));
        assertNull(database.findByAddress("Home"));

        assertEquals(database.findByPhone("123"), PERSON_1);
        assertNull(database.findByPhone("100500"));

        database.deleteByName("Edward");
        assertNull(database.findByName("Edward"));

        database.deleteByAddress("Адрес 3");
        assertNull(database.findByAddress("Адрес 3"));

        database.deleteByPhone("112");
        assertNull(database.findByPhone("112"));

        database.delete(6);
        assertTrue(database.getAll().isEmpty());
    }

    @Test
    @DisplayName("Проверка операций базы данных с блокировкой чтения/записи")
    public void rwLockDatabaseTest() {
        RWLockDatabase database = new RWLockDatabase();

        database.add(PERSON_1);
        database.add(PERSON_1);
        database.add(PERSON_2);
        database.add(PERSON_3);
        database.add(PERSON_4);
        database.add(PERSON_5);
        database.add(PERSON_6);

        assertEquals(database.getAll(), allPersons);

        assertEquals(database.findById(1), PERSON_1);
        assertEquals(database.findById(6), PERSON_6);
        assertNotEquals(database.findById(2), PERSON_4);
        assertNull(database.findById(-1));

        assertEquals(database.findByName("Edward"), List.of(PERSON_1, PERSON_2));
        assertNull(database.findByName("Stan"));

        assertEquals(database.findByAddress("Адрес 3"), List.of(PERSON_3, PERSON_4));
        assertNull(database.findByAddress("Home"));

        assertEquals(database.findByPhone("123"), PERSON_1);
        assertNull(database.findByPhone("100500"));

        database.deleteByName("Edward");
        assertNull(database.findByName("Edward"));

        database.deleteByAddress("Адрес 3");
        assertNull(database.findByAddress("Адрес 3"));

        database.deleteByPhone("112");
        assertNull(database.findByPhone("112"));

        database.delete(6);
        assertTrue(database.getAll().isEmpty());
    }
}
