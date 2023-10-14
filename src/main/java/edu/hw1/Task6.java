package edu.hw1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import org.apache.logging.log4j.LogManager;

public class Task6 {
    private final static org.apache.logging.log4j.Logger LOGGER = LogManager.getLogger();
    private final static int K = 6174;
    private final static int DEC = 10;
    private final static int THOUSAND = 1000;
    private final static int MAX_FOURDIGIT_VALUE = 9999;

    @SuppressWarnings("uncommentedmain")
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        LOGGER.info("Введите число: ");
        int n = sc.nextInt();
        LOGGER.info(countK(n));

        sc.close();
    }

    public static int countK(int p) {
        int n = p;

        if (n < THOUSAND) {
            return -1;
        }
        if (n > MAX_FOURDIGIT_VALUE) {
            return -1;
        }
        if (!checkNotEqualDigits(n)) {
            return -1;
        }

        int count = 0;
        List<Integer> list;

        while (n != K) {
            list = getDigits(n);

            Collections.sort(list);
            int smaller = buildNumber(list);

            Collections.reverse(list);
            int bigger = buildNumber(list);

            n = bigger - smaller;
            count++;
        }

        return count;
    }

    private static boolean checkNotEqualDigits(int p) {
        int n = p;

        int digit = n % DEC;
        n /= DEC;

        while (n > 0) {
            if (n % DEC != digit) {
                return true;
            }
            n /= DEC;
        }

        return false;
    }

    private static int buildNumber(List<Integer> list) {
        int result = 0;

        for (int n : list) {
            result += n;
            result *= DEC;
        }
        result /= DEC;

        return result;
    }

    private static List<Integer> getDigits(int p) {
        int n = p;

        List<Integer> list = new ArrayList<>();

        while (n > 0) {
            list.add(n % DEC);
            n /= DEC;
        }

        return list;
    }

    private Task6() {
    }

}
