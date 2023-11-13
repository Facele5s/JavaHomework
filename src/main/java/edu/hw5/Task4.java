package edu.hw5;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task4 {
    private static final String REGEX = ".*[~!@#$%^&*|].*";
    private static final Pattern PATTERN = Pattern.compile(REGEX);

    private Task4() {

    }

    public static boolean validateStrongPassword(String str) {
        Matcher matcher = PATTERN.matcher(str);

        return matcher.matches();
    }
}
