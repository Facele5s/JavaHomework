package edu.hw5;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task7 {
    private static final String PATTERN1 = "^[01]{2}0[01]*$";
    private static final String PATTERN2 = "^((0[01]*0)|(1[01]*1)|([01]))$";
    private static final String PATTERN3 = "^[01]{1,3}$";

    private Task7() {

    }

    public static boolean checkRegex1(String str) {
        Pattern pattern = Pattern.compile(PATTERN1);
        Matcher matcher = pattern.matcher(str);

        return matcher.matches();
    }

    public static boolean checkRegex2(String str) {
        Pattern pattern = Pattern.compile(PATTERN2);
        Matcher matcher = pattern.matcher(str);

        return matcher.matches();
    }

    public static boolean checkRegex3(String str) {
        Pattern pattern = Pattern.compile(PATTERN3);
        Matcher matcher = pattern.matcher(str);

        return matcher.matches();
    }
}
