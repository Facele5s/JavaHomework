package edu.hw5;

public class Task8 {
    private Task8() {

    }

    public static boolean checkRegex1(String str) {
        return str.matches("^[01]([01]{2})*$");
    }

    public static boolean checkRegex2(String str) {
        return str.matches("^((0([01]{2})*)|(1[01]([01]{2})*))$");
    }

    public static boolean checkRegex4(String str) {
        return str.matches("^(?!(11$|111$))[01]+$");
    }

    public static boolean checkRegex5(String str) {
        return str.matches("^(1[01])*1*$");
    }

    public static boolean checkRegex7(String str) {
        return str.matches("^(?!.*11)+$");
    }
}
