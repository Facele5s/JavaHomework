package edu.hw3;

import java.util.HashMap;
import java.util.Map;

public class Task3 {
    private Task3() {

    }

    public static Map<Object, Integer> freqDict(Object[] objects) {
        Map<Object, Integer> answer = new HashMap<>();

        for (Object o : objects) {
            if (answer.containsKey(o)) {
                int n = answer.get(o);
                n++;
                answer.put(o, n);
            } else {
                answer.put(o, 1);
            }
        }

        return answer;
    }
}
