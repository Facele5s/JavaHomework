package edu.hw5;

public class Task7 {
    private Task7() {

    }

    // содержит не менее 3 символов, причем третий символ равен 0
    public static boolean checkRegex1(String str) {
        return str.matches("^[01]{2}0[01]*$");
    }

    // начинается и заканчивается одним и тем же символом
    public static boolean checkRegex2(String str) {
        return str.matches("^((0[01]*0)|(1[01]*1)|([01]))$");
    }

    // длина не менее 1 и не более 3
    public static boolean checkRegex3(String str) {
        return str.matches("^[01]{1,3}$");
    }
}
