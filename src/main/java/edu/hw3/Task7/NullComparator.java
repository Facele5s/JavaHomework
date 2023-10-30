package edu.hw3.Task7;

import java.util.Comparator;

public class NullComparator implements Comparator<Comparable<Object>> {
    @Override
    public int compare(Comparable<Object> o1, Comparable<Object> o2) {
        if (o1 == null && o2 == null) {
            return 0;
        }
        if (o2 == null) {
            return 1;
        }
        if (o1 == null) {
            return -1;
        }
        return o1.compareTo(o2);
    }
}
