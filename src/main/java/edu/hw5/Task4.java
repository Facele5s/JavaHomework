package edu.hw5;

public class Task4 {
    private Task4() {

    }

    public static boolean validateStrongPassword(String str) {
        if (str == null) {
            return false;
        }

        return str.matches(".*[~!@#$%^&*|].*");
    }
}
