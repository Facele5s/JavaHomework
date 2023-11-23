package edu.hw7.Task3;

import java.util.List;

public interface PersonDatabase {
    void add(Person person);

    void delete(int id);

    List<Person> getAll();

    Person findById(int id);

    List<Person> findByName(String name);

    List<Person> findByAddress(String address);

    Person findByPhone(String phone);

    void deleteByName(String name);

    void deleteByAddress(String address);

    void deleteByPhone(String phone);
}
