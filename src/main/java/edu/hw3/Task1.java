package edu.hw3;

public class Task1 {
    private Task1() {

    }

    public static String atbash(String str) {
        char[] chars = str.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            chars[i] = encode(chars[i]);
        }

        return new String(chars);
    }

    public static char encode(char c) {
        if (c >= 'A' && c <= 'Z') {
            return (char) ('A' + 'Z' - c);
        } else if (c >= 'a' && c <= 'z') {
            return (char) ('a' + 'z' - c);
        } else {
            return c;
        }
    }
}
