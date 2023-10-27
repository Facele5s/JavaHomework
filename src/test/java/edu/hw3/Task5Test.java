package edu.hw3;

import edu.hw3.Task5.Contact;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static edu.hw3.Task5.ContactSorter.parseContacts;
import static org.assertj.core.api.Assertions.assertThat;

public class Task5Test {
    @Test
    @DisplayName("Сортировка контактов по возрастанию")
    public void ascSortTest() {
        List<String> stringContacts = Arrays.asList("John Locke", "Thomas Aquinas", "David Hume", "Rene Descartes");
        List<Contact> contacts = new ArrayList<>();
        contacts.add(new Contact("Thomas Aquinas"));
        contacts.add(new Contact("Rene Descartes"));
        contacts.add(new Contact("David Hume"));
        contacts.add(new Contact("John Locke"));

        assertThat(contacts).isEqualTo(parseContacts(stringContacts, "ASC"));

        stringContacts = Arrays.asList("В Г", "А Б", "Д");
        contacts.clear();
        contacts.add(new Contact("А Б"));
        contacts.add(new Contact("В Г"));
        contacts.add(new Contact("Д"));

        assertThat(contacts).isEqualTo(parseContacts(stringContacts, "ASC"));
    }

    @Test
    @DisplayName("Сортировка контактов по убыванию")
    public void descSortTest() {
        List<String> stringContacts = Arrays.asList("Paul Erdos", "Leonhard Euler", "Carl Gauss");
        List<Contact> contacts = new ArrayList<>();
        contacts.add(new Contact("Carl Gauss"));
        contacts.add(new Contact("Leonhard Euler"));
        contacts.add(new Contact("Paul Erdos"));

        assertThat(contacts).isEqualTo(parseContacts(stringContacts, "DESC"));

        stringContacts = Arrays.asList("А", "Г", "Б В");
        contacts.clear();
        contacts.add(new Contact("Г"));
        contacts.add(new Contact("Б В"));
        contacts.add(new Contact("А"));

        assertThat(contacts).isEqualTo(parseContacts(stringContacts, "DESC"));
    }

    @Test
    @DisplayName("Сортировка пустого списка контактов")
    public void emptySortTest() {
        List<String> stringContacts = new ArrayList<>();
        List<Contact> contacts = new ArrayList<>();

        assertThat(contacts).isEqualTo(parseContacts(stringContacts, "DESC"));

        assertThat(contacts).isEqualTo(parseContacts(stringContacts, "DESC"));
    }
}
