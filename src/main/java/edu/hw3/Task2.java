package edu.hw3;

import java.util.ArrayList;
import java.util.List;

public class Task2 {
    private Task2() {

    }

    public static String[] clusterize(String str) {
        List<String> answer = new ArrayList<>();

        if (checkInput(str)) {
            int brackets = 0;
            StringBuilder cluster = new StringBuilder();

            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);

                if (c == '(') {
                    brackets++;
                } else {
                    brackets--;
                }

                cluster.append(c);

                if (brackets == 0) {
                    answer.add(cluster.toString());
                    cluster.setLength(0);
                } else if (brackets < 0 || i == str.length() - 1) {
                    answer.clear();
                    break;
                }
            }
        }

        return answer.toArray(new String[] {});
    }

    private static boolean checkInput(String str) {
        for (char c : str.toCharArray()) {
            if (c != '(' && c != ')') {
                return false;
            }
        }

        return true;
    }
}
