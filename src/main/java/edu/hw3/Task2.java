package edu.hw3;

import java.util.ArrayList;
import java.util.List;

public class Task2 {
    private Task2() {

    }

    public static String[] clusterize(String str) {
        List<String> answer = new ArrayList<>();

        if (checkInput(str)) {
            int leftBracketCount = 0;
            int rightBracketCount = 0;
            boolean isClusterOpened = false;
            StringBuilder cluster = new StringBuilder();

            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);

                if (c == ')') {
                    if (isClusterOpened) {
                        rightBracketCount++;
                        cluster.append(c);
                    } else {
                        answer.clear();
                        break;
                    }
                } else {
                    if (!isClusterOpened) {
                        isClusterOpened = true;
                    }
                    leftBracketCount++;
                    cluster.append(c);
                }

                if (leftBracketCount == rightBracketCount) {
                    leftBracketCount = 0;
                    rightBracketCount = 0;
                    isClusterOpened = false;
                    answer.add(cluster.toString());
                    cluster.setLength(0);
                }

                // Если кластер открывается на последнем символе, значит
                // он уже не закроется
                if (isClusterOpened && i == str.length() - 1) {
                    answer.clear();
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
