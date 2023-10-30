package edu.hw2;

import edu.hw2.Task2.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import edu.hw2.Task3.PopularCommandExecutor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task3Test {
    @ParameterizedTest
    @DisplayName("Проверка двух команд")
    @CsvSource({
        "apt evolve Grey.human && apt upgrade Stem.exe",
        "apt update server.properties"
    })
    public void someCommandsTest(String command) {
        boolean success = false;
        boolean expected = true;

        try {
            PopularCommandExecutor executor = new PopularCommandExecutor(10);

            try {
                executor.tryExecute(command);
            } catch (Exception e) {
                throw new RuntimeException();
            }

            success = true;
        } catch (RuntimeException e) {
            expected = false;
        }

        assertEquals(expected, success);
    }

    @RepeatedTest(20)
    @DisplayName("Проверка исполнителя на обновления")
    public void updateTest() throws Exception {
        boolean success = false;
        boolean expected = true;

        try {
            PopularCommandExecutor executor = new PopularCommandExecutor(20);
            executor.updatePackages();
            success = true;
        } catch (RuntimeException e) {
            expected = false;
        }

        assertEquals(expected, success);
    }
}
