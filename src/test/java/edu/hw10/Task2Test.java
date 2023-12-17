package edu.hw10;

import edu.hw10.Task2.CacheProxy;
import edu.hw10.Task2.FibonacciCalculator;
import edu.hw10.Task2.FibCalculator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Path;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

public class Task2Test {
    private static final Path DIRECTORY = Path.of("src/test/java/edu/hw10/");
    private static final Logger LOGGER = LogManager.getLogger();

    @Test
    @DisplayName("Проверка кэширования")
    public void proxyTest() {
        FibCalculator calculator = new FibonacciCalculator();
        FibCalculator proxy = CacheProxy.create(calculator, calculator.getClass(), DIRECTORY);

        LOGGER.info(proxy.fib(10));

        File file = new File(DIRECTORY.toString(), "fib_[10].cache");

        if (file.exists()) {
            file.delete();
            assertTrue(true);
        } else {
            fail();
        }
    }

    @Test
    @DisplayName("Проверка кэшированного значения")
    public void cachedValueCheck() {
        File file = new File(DIRECTORY.toString(), "fib_[15].cache");

        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(file))) {
            long cachedValue = (long) inputStream.readObject();

            assertEquals(610, cachedValue);
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
