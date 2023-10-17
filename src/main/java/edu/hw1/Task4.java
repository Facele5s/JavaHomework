package edu.hw1;

public class Task4 {
    public static String fixString(String str) {
        if (str == null) {
            return null;
        }
        if (str.isEmpty()) {
            return "";
        }
        if (str.length() == 1) {
            return str;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < str.length(); i += 2) {
            sb.append(str.charAt(i));
            sb.append(str.charAt(i - 1));
        }
        if (str.length() % 2 == 1) {
            sb.append(str.charAt(str.length() - 1));
        }

        return sb.toString();
    }

    private Task4() {
    }
}
