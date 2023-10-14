package edu.hw1;

import java.util.Scanner;
import org.apache.logging.log4j.LogManager;

public class Task4 {
    private final static org.apache.logging.log4j.Logger LOGGER = LogManager.getLogger();

    @SuppressWarnings("uncommentedmain")
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        LOGGER.info("Введите строку: ");
        String str = sc.nextLine();
        LOGGER.info(fixString(str));

        sc.close();
    }

    public static String fixString(String str) {
        if (str == null) {
            return null;
        }
        if (str.isEmpty()) {
            return "";
        }
        if (str.length() == 1) {
            return str;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < str.length(); i += 2) {
            sb.append(str.charAt(i));
            sb.append(str.charAt(i - 1));
        }
        if (str.length() % 2 == 1) {
            sb.append(str.charAt(str.length() - 1));
        }

        return sb.toString();
    }

    private Task4() {
    }

}
