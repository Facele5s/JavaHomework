package edu.hw5;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task8 {
    private static final String PATTERN1 = "^[01]([01]{2})*$";
    private static final String PATTERN2 = "^((0([01]{2})*)|(1[01]([01]{2})*))$";
    private static final String PATTERN3 = "^$";
    private static final String PATTERN4 = "^(?!(11$|111$))[01]+$";
    private static final String PATTERN5 = "^(1[01])*1*$";
    private static final String PATTERN6 = "^$";
    private static final String PATTERN7 = "^(?!.*11)+$";

    private Task8() {

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

    public static boolean checkRegex4(String str) {
        Pattern pattern = Pattern.compile(PATTERN4);
        Matcher matcher = pattern.matcher(str);

        return matcher.matches();
    }

    public static boolean checkRegex5(String str) {
        Pattern pattern = Pattern.compile(PATTERN5);
        Matcher matcher = pattern.matcher(str);

        return matcher.matches();
    }

    public static boolean checkRegex6(String str) {
        Pattern pattern = Pattern.compile(PATTERN6);
        Matcher matcher = pattern.matcher(str);

        return matcher.matches();
    }

    public static boolean checkRegex7(String str) {
        Pattern pattern = Pattern.compile(PATTERN7);
        Matcher matcher = pattern.matcher(str);

        return matcher.matches();
    }
}
