package edu.hw1;

import java.util.Scanner;
import org.apache.logging.log4j.LogManager;

public class Task3 {
    private final static org.apache.logging.log4j.Logger LOGGER = LogManager.getLogger();

    @SuppressWarnings("uncommentedmain")
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        LOGGER.info("Введите длину первого массива: ");
        int length1 = sc.nextInt();
        LOGGER.info("Введите числа первого массива: ");
        int[] arr1 = new int[length1];
        for (int i = 0; i < length1; i++) {
            arr1[i] = sc.nextInt();
        }

        LOGGER.info("Введите длину второго массива: ");
        int length2 = sc.nextInt();
        LOGGER.info("Введите числа второго массива: ");
        int[] arr2 = new int[length2];
        for (int i = 0; i < length2; i++) {
            arr2[i] = sc.nextInt();
        }

        LOGGER.info(isNestable(arr1, arr2));

        sc.close();
    }

    public static boolean isNestable(int[] arr1, int[] arr2) {
        if (arr1 == null || arr2 == null) {
            return false;
        }
        if (arr1.length == 0 || arr2.length == 0) {
            return false;
        }

        int min1 = arr1[0];
        int max1 = arr1[0];
        int min2 = arr2[0];
        int max2 = arr2[0];

        for (int n : arr1) {
            if (n < min1) {
                min1 = n;
            }
            if (n > max1) {
                max1 = n;
            }
        }
        for (int n : arr2) {
            if (n < min2) {
                min2 = n;
            }
            if (n > max2) {
                max2 = n;
            }
        }

        return (min1 > min2 && max1 < max2);
    }

    private Task3() {
    }

}
