package edu.hw3.Task5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ContactSorter {
    private ContactSorter() {

    }

    public static List<Contact> parseContacts(List<String> stringContacts, String sortType) {
        if (stringContacts == null) {
            return new ArrayList<>();
        }

        List<Contact> contacts = new ArrayList<>();
        for (String s : stringContacts) {
            Contact contact = new Contact(s);
            contacts.add(contact);
        }

        if (sortType.equals("ASC")) {
            Collections.sort(contacts);
        } else if (sortType.equals("DESC")) {
            contacts.sort(Collections.reverseOrder());
        } else {
            return new ArrayList<>();
        }

        return contacts;
    }
}
