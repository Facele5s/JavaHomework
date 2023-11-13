package edu.hw5;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task5 {
    private static final String REGEX = "^[А-Я]\\d{3}[А-Я]{2}(([1-9]\\d{2})|(\\d{2}))$";
    private static final Pattern PATTERN = Pattern.compile(REGEX);

    private Task5() {

    }

    public static boolean validateRusNumber(String str) {
        Matcher matcher = PATTERN.matcher(str);

        return matcher.matches();
    }
}
