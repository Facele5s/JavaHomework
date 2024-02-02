package edu.hw8;

import edu.hw8.Task3.FileParser;
import edu.hw8.Task3.MultiThreadHacker;
import edu.hw8.Task3.SingleThreadHacker;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.util.Map;

public class Task3Test {
    private static final Logger LOGGER = LogManager.getLogger();

    private static final String PATH = "src/main/java/edu/hw8/Task3/passwords_encrypted.txt";

    @Test
    @DisplayName("Однопоточный взлом паролей")
    public void singleThreadHacking() throws IOException {
        SingleThreadHacker hacker = new SingleThreadHacker(FileParser.readPasswords(PATH));

        long t1 = System.currentTimeMillis();
        Map<String, String> usersData = hacker.hackPasswords();
        long t2 = System.currentTimeMillis();

        LOGGER.info("Пароли взломаны за " + (t2 - t1) / 1000 + " секунд");
        usersData.forEach((key, value) -> {
            LOGGER.info("Имя пользователя: " + key);
            LOGGER.info("Пароль: " + value);
        });
    }

    @Test
    @DisplayName("Многопоточный взлом паролей")
    public void multiThreadHacking() throws IOException {
        MultiThreadHacker hacker = new MultiThreadHacker(FileParser.readPasswords(PATH), 6);
        Map<String, String> usersData = hacker.hackPasswords();

        usersData.forEach((key, value) -> {
            LOGGER.info("Имя пользователя: " + key);
            LOGGER.info("Пароль: " + value);
        });
        LOGGER.info("");

        for (int i = 1; i <= 6; i++) {
            hacker = new MultiThreadHacker(FileParser.readPasswords(PATH), i);
            long t1 = System.currentTimeMillis();
            hacker.hackPasswords();
            long t2 = System.currentTimeMillis();

            long time = (t2 - t1) / 1000;

            LOGGER.info(String.format("При использовании %d потоков на взлом потребуется секунд: %d",
                i, time));
        }
    }
}
