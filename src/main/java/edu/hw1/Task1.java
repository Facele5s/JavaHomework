package edu.hw1;

import java.util.Scanner;
import org.apache.logging.log4j.LogManager;

public class Task1 {
    private final static org.apache.logging.log4j.Logger LOGGER = LogManager.getLogger();
    private final static int SEC_IN_MIN = 60;

    @SuppressWarnings("uncommentedmain")
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        LOGGER.info("Введите время: ");
        String time = sc.nextLine();
        LOGGER.info(minutesToSeconds(time));

        sc.close();
    }

    public static int minutesToSeconds(String time) {
        int result = -1;

        if (checkInput(time)) {
            int indexColon = time.indexOf(':');

            int minutes = Integer.parseInt(time.substring(0, indexColon));
            int seconds = Integer.parseInt(time.substring(indexColon + 1));

            if (seconds < SEC_IN_MIN && seconds >= 0) {
                result = minutes * SEC_IN_MIN + seconds;
            }
        }

        return result;
    }

    private static boolean checkInput(String time) {
        boolean checkResult = true;
        boolean hasColon = false;

        if (time == null) {
            return false;
        }
        if (time.isEmpty()) {
            checkResult = false;
        }
        for (int i = 0; i < time.length(); i++) {
            char c = time.charAt(i);

            if (c == ':') {
                if (!hasColon) {
                    hasColon = true;
                    //Строка не подходит, если двоеточие находится в начале или в конце
                    if (i == 0 || i == time.length() - 1) {
                        checkResult = false;
                    }
                } else {
                    checkResult = false;   //Строка не подходит, если в ней больше одного двоеточия
                    break;
                }
            } else if (!Character.isDigit(c)) {
                //Строка не подходит, если она содержит что-либо кроме цифр и двоеточия
                checkResult = false;
            }
        }

        return checkResult;
    }

    private Task1() {
    }

}
