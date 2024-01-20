package edu.hw7.Task3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SimpleDatabase implements PersonDatabase {
    private final Map<Integer, Person> idPersons = new HashMap<>();
    private final Map<String, List<Person>> namePersons = new HashMap<>();
    private final Map<String, List<Person>> addressPersons = new HashMap<>();
    private final Map<String, Person> phonePersons = new HashMap<>();

    @Override
    public Set<Person> getAll() {
        return new HashSet<>(idPersons.values());
    }

    @Override
    public void add(Person person) {
        if (person != null
            && !idPersons.containsKey(person.id())
            && !phonePersons.containsKey(person.phoneNumber())) {
            addId(person);
            addName(person);
            addAddress(person);
            addPhone(person);
        }
    }

    @Override
    public void delete(int id) {
        if (idPersons.containsKey(id)) {
            Person personToDelete = idPersons.get(id);

            idPersons.remove(id);
            clearName(personToDelete);
            clearAddress(personToDelete);
            clearPhone(personToDelete);
        }
    }

    @Override
    public Person findById(int id) {
        return idPersons.get(id);
    }

    @Override
    public List<Person> findByName(String name) {
        return namePersons.get(name);
    }

    @Override
    public List<Person> findByAddress(String address) {
        return addressPersons.get(address);
    }

    @Override
    public Person findByPhone(String phone) {
        return phonePersons.get(phone);
    }

    @Override
    public void deleteByName(String name) {
        List<Integer> idsToDelete = namePersons.get(name)
            .stream().map(Person::id).toList();

        idsToDelete.forEach(this::delete);
    }

    @Override
    public void deleteByAddress(String address) {
        List<Integer> idsToDelete = addressPersons.get(address)
            .stream().map(Person::id).toList();

        idsToDelete.forEach(this::delete);
    }

    @Override
    public void deleteByPhone(String phone) {
        Person personToDelete = phonePersons.get(phone);

        delete(personToDelete.id());
    }

    private void addId(Person person) {
        int id = person.id();
        idPersons.put(id, person);
    }

    private void addName(Person person) {
        String name = person.name();

        if (namePersons.containsKey(name)) {
            namePersons.get(name).add(person);
        } else {
            List<Person> persons = new ArrayList<>();
            persons.add(person);
            namePersons.put(name, persons);
        }
    }

    private void addAddress(Person person) {
        String address = person.address();

        if (addressPersons.containsKey(address)) {
            addressPersons.get(address).add(person);
        } else {
            List<Person> persons = new ArrayList<>();
            persons.add(person);
            addressPersons.put(address, persons);
        }
    }

    private void addPhone(Person person) {
        String phone = person.phoneNumber();
        phonePersons.put(phone, person);
    }

    private void clearName(Person person) {
        String name = person.name();

        if (namePersons.get(name).size() == 1) {
            namePersons.remove(name);
        } else {
            namePersons.get(name).remove(person);
        }
    }

    private void clearAddress(Person person) {
        String address = person.address();

        if (addressPersons.get(address).size() == 1) {
            addressPersons.remove(address);
        } else {
            addressPersons.get(address).remove(person);
        }
    }

    private void clearPhone(Person person) {
        phonePersons.remove(person.phoneNumber());
    }
}
