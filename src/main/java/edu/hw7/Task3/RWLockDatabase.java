package edu.hw7.Task3;

import java.util.List;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class RWLockDatabase extends SimpleDatabase {
    private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    @Override
    public List<Person> getAll() {
        lock.readLock().lock();

        try {
            return super.getAll();
        } finally {
            lock.readLock().unlock();
        }
    }

    @Override
    public void add(Person person) {
        lock.readLock().lock();

        try {
            super.add(person);
        } finally {
            lock.readLock().unlock();
        }
    }

    @Override
    public void delete(int id) {
        lock.readLock().lock();

        try {
            super.delete(id);
        } finally {
            lock.readLock().unlock();
        }
    }

    @Override
    public Person findById(int id) {
        lock.readLock().lock();

        try {
            return super.findById(id);
        } finally {
            lock.readLock().unlock();
        }
    }

    @Override
    public List<Person> findByName(String name) {
        lock.readLock().lock();

        try {
            return super.findByName(name);
        } finally {
            lock.readLock().unlock();
        }
    }

    @Override
    public List<Person> findByAddress(String address) {
        lock.readLock().lock();

        try {
            return super.findByAddress(address);
        } finally {
            lock.readLock().unlock();
        }
    }

    @Override
    public Person findByPhone(String phone) {
        lock.readLock().lock();

        try {
            return super.findByPhone(phone);
        } finally {
            lock.readLock().unlock();
        }
    }

    @Override
    public void deleteByName(String name) {
        lock.readLock().lock();

        try {
            super.deleteByName(name);
        } finally {
            lock.readLock().unlock();
        }
    }

    @Override
    public void deleteByAddress(String address) {
        lock.readLock().lock();

        try {
            super.deleteByAddress(address);
        } finally {
            lock.readLock().unlock();
        }
    }

    @Override
    public void deleteByPhone(String phone) {
        lock.readLock().lock();

        try {
            super.deleteByPhone(phone);
        } finally {
            lock.readLock().unlock();
        }
    }
}
