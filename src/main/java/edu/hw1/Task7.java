package edu.hw1;

import java.util.Scanner;
import org.apache.logging.log4j.LogManager;

public class Task7 {
    private final static org.apache.logging.log4j.Logger LOGGER = LogManager.getLogger();
    private final static String ARROW = " -> ";

    @SuppressWarnings("uncommentedmain")
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        LOGGER.info("Введите число: ");
        int n = sc.nextInt();
        LOGGER.info("Введите размер сдвига (>0 - вправо, <0 - влево): ");
        int shift = sc.nextInt();
        LOGGER.info(n + ARROW + rotate(n, shift));
        LOGGER.info(Integer.toBinaryString(n) + ARROW + Integer.toBinaryString(rotate(n, shift)));

        sc.close();
    }

    public static int rotate(int n, int shift) {
        if (n < 0) {
            return -1;
        }
        if (shift == 0) {
            return n;
        } else {
            char[] bits = Integer.toBinaryString(n).toCharArray();

            if (shift > 0) {
                return rotateRight(bits, shift);
            } else {
                return rotateLeft(bits, -shift);
            }
        }
    }

    private static int rotateRight(char[] bits, int shft) {
        int shift = shft % bits.length;

        reverse(bits, bits.length - shift, bits.length - 1);
        reverse(bits, 0, bits.length - shift - 1);
        reverse(bits, 0, bits.length - 1);

        String result = new String(bits);
        return Integer.parseInt(result, 2);
    }

    private static int rotateLeft(char[] bits, int shft) {
        int shift = shft % bits.length;

        reverse(bits, 0, bits.length - 1);
        reverse(bits, bits.length - shift, bits.length - 1);
        reverse(bits, 0, bits.length - shift - 1);

        String result = new String(bits);
        return Integer.parseInt(result, 2);
    }

    private static void reverse(char[] arr, int ii, int jj) {
        int i = ii;
        int j = jj;

        while (i < j) {
            char c = arr[i];
            arr[i] = arr[j];
            arr[j] = c;

            i++;
            j--;
        }
    }

    private Task7() {
    }

}
