package edu.hw1;

public class Task2 {
    private final static int DECIMAL_SYSTEM_BASE = 10;

    public static int countDigits(int p) {
        int result = 0;
        int n = Math.abs(p);

        while (n > 0) {
            result++;
            // Делим число на основание системы счисления, чтобы отбросить последнюю цифру
            n /= DECIMAL_SYSTEM_BASE;
        }

        if (result == 0) {
            result++; //Число 0 имеет 1 цифру
        }
        return result;
    }

    private Task2() {
    }
}
