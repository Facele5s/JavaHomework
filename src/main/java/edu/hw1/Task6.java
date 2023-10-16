package edu.hw1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Task6 {
    private final static int KAPREKAR_CONSTANT = 6174;
    private final static int DECIMAL_SYSTEM_BASE = 10;
    private final static int MIN_FOUR_DIGIT_VALUE = 1000;
    private final static int MAX_FOUR_DIGIT_VALUE = 9999;

    public static int countK(int p) {
        int n = p;

        if (n < MIN_FOUR_DIGIT_VALUE || n > MAX_FOUR_DIGIT_VALUE || !checkNotEqualDigits(n)) {
            return -1;
        }

        int stepsCount = 0;
        List<Integer> list;

        while (n != KAPREKAR_CONSTANT) {
            list = getDigits(n);

            Collections.sort(list);
            int smaller = buildNumber(list);

            Collections.reverse(list);
            int bigger = buildNumber(list);

            n = bigger - smaller;
            stepsCount++;
        }

        return stepsCount;
    }

    private static boolean checkNotEqualDigits(int p) {
        int n = p;

        int digit = n % DECIMAL_SYSTEM_BASE;
        n /= DECIMAL_SYSTEM_BASE;

        while (n > 0) {
            if (n % DECIMAL_SYSTEM_BASE != digit) {
                return true;
            }
            // Делим число на основание системы счисления, чтобы отбросить последнюю цифру
            n /= DECIMAL_SYSTEM_BASE;
        }

        return false;
    }

    private static int buildNumber(List<Integer> list) {
        int result = 0;

        for (int n : list) {
            // Умножаем число на основание системы счисления, чтобы потом приписпать цифру
            result *= DECIMAL_SYSTEM_BASE;
            result += n;
        }

        return result;
    }

    private static List<Integer> getDigits(int p) {
        int n = p;

        List<Integer> list = new ArrayList<>();

        while (n > 0) {
            list.add(n % DECIMAL_SYSTEM_BASE);
            // Делим число на основание системы счисления, чтобы отбросить последнюю цифру
            n /= DECIMAL_SYSTEM_BASE;
        }

        return list;
    }

    private Task6() {
    }
}
