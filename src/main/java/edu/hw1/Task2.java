package edu.hw1;

import java.util.Scanner;
import org.apache.logging.log4j.LogManager;

public class Task2 {
    private final static org.apache.logging.log4j.Logger LOGGER = LogManager.getLogger();

    private final static int DEC = 10;

    @SuppressWarnings("uncommentedmain")
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        LOGGER.info("Введите число: ");
        int n = sc.nextInt();
        LOGGER.info(countDigits(n));

        sc.close();
    }

    public static int countDigits(int p) {
        int result = 0;
        int n = Math.abs(p);

        while (n > 0) {
            result++;
            n /= DEC;
        }

        if (result == 0) {
            result++; //Число 0 имеет 1 цифру
        }
        return result;
    }

    private Task2() {
    }

}
