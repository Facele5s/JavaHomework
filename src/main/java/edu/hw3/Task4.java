package edu.hw3;

public class Task4 {
    private static final int[] ROMAN_VALS = new int[] {
        1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000
    };
    private static final String[] ROMAN_DIGITS = new String[] {
        "I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"
    };

    private Task4() {

    }

    public static String convertToRoman(int n) {
        if (n == 0) {
            return "N";
        }
        if (n < 0) {
            return "";
        }

        int arabianNumber = n;
        StringBuilder romanNumber = new StringBuilder();

        while (arabianNumber != 0) {
            for (int i = ROMAN_VALS.length - 1; i >= 0; i--) {
                if (ROMAN_VALS[i] <= arabianNumber) {
                    arabianNumber -= ROMAN_VALS[i];
                    romanNumber.append(ROMAN_DIGITS[i]);
                    break;
                }
            }
        }

        return romanNumber.toString();
    }
}
