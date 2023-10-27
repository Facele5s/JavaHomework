package edu.hw3.Task5;

import java.util.Objects;
import org.jetbrains.annotations.NotNull;

public class Contact implements Comparable<Contact> {
    private String name;
    private String surname;

    public Contact(String nameString) {
        String[] nameParams = nameString.split(" ");

        if (nameParams.length == 1) {
            name = nameParams[0];
        } else if (nameParams.length == 2) {
            name = nameParams[0];
            surname = nameParams[1];
        } else {
            throw new IllegalArgumentException("Некорректный ввод");
        }
    }

    @Override
    public int compareTo(@NotNull Contact o) {
        if (this.surname == null || o.surname == null) {
            return this.name.compareTo(o.name);
        } else {
            return this.surname.compareTo(o.surname);
        }
    }

    @Override public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        Contact contact = (Contact) o;
        return Objects.equals(name, contact.name) && Objects.equals(surname, contact.surname);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
