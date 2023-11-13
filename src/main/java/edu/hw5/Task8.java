package edu.hw5;

public class Task8 {
    private Task8() {

    }

    // нечетной длины
    public static boolean checkRegex1(String str) {
        if (str == null) {
            return false;
        }

        return str.matches("^[01]([01]{2})*$");
    }

    // начинается с 0 и имеет нечетную длину, или начинается с 1 и имеет четную длину
    public static boolean checkRegex2(String str) {
        if (str == null) {
            return false;
        }

        return str.matches("^((0([01]{2})*)|(1[01]([01]{2})*))$");
    }

    // любая строка, кроме 11 или 111
    public static boolean checkRegex4(String str) {
        if (str == null) {
            return false;
        }

        return str.matches("^(?!(11$|111$))[01]*$");
    }

    // каждый нечетный символ равен 1
    public static boolean checkRegex5(String str) {
        if (str == null) {
            return false;
        }

        return str.matches("^1(01|11|0$)*$");
    }

    // нет последовательных 1
    public static boolean checkRegex7(String str) {
        if (str == null) {
            return false;
        }

        return str.matches("^(?!.*11)[01]*$");
    }
}
