package edu.hw5;

public class Task7 {
    private Task7() {

    }

    public static boolean hasThreeMoreCharsWithThirdZero(String str) {
        if (str == null) {
            return false;
        }

        return str.matches("^[01]{2}0[01]*$");
    }

    public static boolean hasSameStartEndChar(String str) {
        if (str == null) {
            return false;
        }

        return str.matches("^((0[01]*0)|(1[01]*1)|([01]))$");
    }

    public static boolean lengthBetweenOneThree(String str) {
        if (str == null) {
            return false;
        }

        return str.matches("^[01]{1,3}$");
    }
}
