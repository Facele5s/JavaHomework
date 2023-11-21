package edu.hw5;

public class Task8 {
    private Task8() {

    }

    public static boolean isOddLength(String str) {
        if (str == null) {
            return false;
        }

        return str.matches("^[01]([01]{2})*$");
    }

    public static boolean zeroOddOrOneEven(String str) {
        if (str == null) {
            return false;
        }

        return str.matches("^((0([01]{2})*)|(1[01]([01]{2})*))$");
    }

    public static boolean not11or111(String str) {
        if (str == null) {
            return false;
        }

        return str.matches("^(?!(11$|111$))[01]*$");
    }

    public static boolean isEveryOddChar1(String str) {
        if (str == null) {
            return false;
        }

        return str.matches("^1(01|11|0$)*$");
    }

    public static boolean noSequentialOnes(String str) {
        if (str == null) {
            return false;
        }

        return str.matches("^(?!.*11)[01]*$");
    }
}
