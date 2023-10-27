package edu.hw3;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class BackwardIterator<T> implements Iterator<T> {
    private int currentPosition;
    private final List<T> collection;

    public BackwardIterator(List<T> collection) {
        this.collection = collection;
        currentPosition = collection.size() - 1;
    }

    @Override
    public boolean hasNext() {
        return currentPosition >= 0;
    }

    @Override
    public T next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return collection.get(currentPosition--);
    }
}
