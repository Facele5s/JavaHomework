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
        char letter = Character.toUpperCase(c);

        if (letter >= 'A' && letter <= 'Z') {
            letter = (char) ('A' + 'Z' - letter);

            if (Character.isLowerCase(c)) {
                letter = Character.toLowerCase(letter);
            }

            return letter;
        }

        return c;
    }
}
