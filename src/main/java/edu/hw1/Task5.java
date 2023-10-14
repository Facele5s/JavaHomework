package edu.hw1;

import java.util.Scanner;
import org.apache.logging.log4j.LogManager;

public class Task5 {
    private final static org.apache.logging.log4j.Logger LOGGER = LogManager.getLogger();
    private final static int DEC = 10;
    private final static int HUNDRED = 100;
    private final static int MAX_ONEDIGIT_VALUE = 9;

    @SuppressWarnings("uncommentedmain")
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        LOGGER.info("Введите число: ");
        int n = sc.nextInt();
        LOGGER.info(isPalindromeDescendant(n));

        sc.close();
    }

    public static boolean isPalindromeDescendant(int p) {
        int n = Math.abs(p);
        if (n < DEC) {
            return true; //Все однозначные числа являются палиндромами
        }

        while (n > DEC) {
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
        if (s.length() % 2 == 1) {
            s = s + "0";
        }

        for (int i = 1; i < s.length(); i += 2) {
            int pair = 0;
            pair += Integer.parseInt(Character.toString(s.charAt(i)));
            pair += Integer.parseInt(Character.toString(s.charAt(i - 1)));

            if (pair > MAX_ONEDIGIT_VALUE) {
                descendant *= HUNDRED;
            } else {
                descendant *= DEC;
            }
            descendant += pair;
        }

        return descendant;
    }

    private Task5() {
    }

}
