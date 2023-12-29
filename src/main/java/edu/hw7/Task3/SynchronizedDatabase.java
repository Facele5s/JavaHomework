package edu.hw7.Task3;

import java.util.List;
import java.util.Set;

public class SynchronizedDatabase extends SimpleDatabase {
    @Override
    public synchronized Set<Person> getAll() {
        return super.getAll();
    }

    @Override
    public synchronized void add(Person person) {
        super.add(person);
    }

    @Override
    public synchronized void delete(int id) {
        super.delete(id);
    }

    @Override
    public synchronized Person findById(int id) {
        return super.findById(id);
    }

    @Override
    public synchronized List<Person> findByName(String name) {
        return super.findByName(name);
    }

    @Override
    public synchronized List<Person> findByAddress(String address) {
        return super.findByAddress(address);
    }

    @Override
    public synchronized Person findByPhone(String phone) {
        return super.findByPhone(phone);
    }

    @Override
    public synchronized void deleteByName(String name) {
        super.deleteByName(name);
    }

    @Override
    public synchronized void deleteByAddress(String address) {
        super.deleteByAddress(address);
    }

    @Override
    public synchronized void deleteByPhone(String phone) {
        super.deleteByPhone(phone);
    }
}
