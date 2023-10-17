package edu.hw1;

public class Task5 {
    private final static int ONE_DIGIT_SPACER = 10;
    private final static int TWO_DIGIT_SPACER = 100;
    private final static int MAX_ONE_DIGIT_VALUE = 9;

    public static boolean isPalindromeDescendant(int p) {
        int n = Math.abs(p);
        if (n <= MAX_ONE_DIGIT_VALUE) {
            return true; //Все однозначные числа являются палиндромами
        }

        while (n > MAX_ONE_DIGIT_VALUE) {
            if (isPalindrome(n)) {
                return true;
            } else {
                n = getDescendant(n);
            }
        }

        return false;
    }

    private static boolean isPalindrome(int n) {
        String s = Integer.toString(n);

        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
                return false;
            }
        }

        return true;
    }

    private static int getDescendant(int n) {
        int descendant = 0;
        String s = Integer.toString(n);
        // Если число имеет нечётную длину, припишем для удобства 0
        if (s.length() % 2 == 1) {
            s = s + "0";
        }

        for (int i = 1; i < s.length(); i += 2) {
            int pair = 0;
            pair += Integer.parseInt(Character.toString(s.charAt(i)));
            pair += Integer.parseInt(Character.toString(s.charAt(i - 1)));

            if (pair > ONE_DIGIT_SPACER) {
                // Умножаем число на 100, если нужно приписать две цифры
                descendant *= TWO_DIGIT_SPACER;
            } else {
                // Умножаем число на 10, если нужно приписать одну цифру
                descendant *= ONE_DIGIT_SPACER;
            }
            descendant += pair;
        }

        return descendant;
    }

    private Task5() {
    }
}
