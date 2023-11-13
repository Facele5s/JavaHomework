package edu.hw5;

public class Task5 {
    private Task5() {

    }

    public static boolean validateRusNumber(String str) {
        return str.matches("^[А-Я]\\d{3}[А-Я]{2}(([1-9]\\d{2})|(\\d{2}))$");
    }
}
