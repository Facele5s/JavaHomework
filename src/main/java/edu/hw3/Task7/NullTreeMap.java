package edu.hw3.Task7;

import java.util.Comparator;
import java.util.TreeMap;

public class NullTreeMap<A, B> extends TreeMap<A, B> {
    private static final Comparator<Comparable<Object>> COMPARATOR = new NullComparator();

    public NullTreeMap() {
        super(getComparator());
    }

    @SuppressWarnings("unchecked")
    private static <T> Comparator<T> getComparator() {
        return (Comparator<T>) COMPARATOR;
    }
}
