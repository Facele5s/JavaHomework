package edu.hw7;

import edu.hw7.Task4.MultithreadPICalculator;
import edu.hw7.Task4.SinglethreadPICalculator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.text.DecimalFormat;

public class Task4Test {
    private static final Logger LOGGER = LogManager.getLogger();

    @Test
    @DisplayName("Проверка однопоточного вычисления числа Пи")
    public void singleThreadPiCalcTest() {
        long t1 = System.currentTimeMillis();
        LOGGER.info(SinglethreadPICalculator.calculatePI(1000));
        long t2 = System.currentTimeMillis();
        LOGGER.info("Однопоточный режим. Затрачено времени: " + (t2 - t1) / 1000D + "с\n");

        t1 = System.currentTimeMillis();
        LOGGER.info(SinglethreadPICalculator.calculatePI(1000000000));
        t2 = System.currentTimeMillis();
        LOGGER.info("Однопоточный режим. Затрачено времени: " + (t2 - t1) / 1000D + "с");
    }

    @Test
    @DisplayName("Проверка многопоточного вычисления числа Пи")
    public void multiThreadPiCalcTest() {
        for (int i = 1; i <= 6; i++) {
            long t1 = System.currentTimeMillis();
            LOGGER.info(MultithreadPICalculator.calculatePI(1_000_000_000, i));
            long t2 = System.currentTimeMillis();
            LOGGER.info("Многопоточный режим. 10^9 итераций. Использовано потоков: " + i);
            LOGGER.info("Затрачено времени: " + (t2 - t1) / 1000D + "с" + "\n");
        }
    }

    @Test
    @DisplayName("Оценка погрешностей при разгом количестве итераций")
    public void errorRateTest() {
        double pi = MultithreadPICalculator.calculatePI(0, 6);
        LOGGER.info(pi);
        LOGGER.info("Количество итераций: 0");
        LOGGER.info("Погрешность: " + Math.abs(Math.PI - pi) + "\n");

        pi = MultithreadPICalculator.calculatePI(1, 6);
        LOGGER.info(pi);
        LOGGER.info("Количество итераций: 1");
        LOGGER.info("Погрешность: " + Math.abs(Math.PI - pi) + "\n");

        pi = MultithreadPICalculator.calculatePI(1000, 6);
        LOGGER.info(pi);
        LOGGER.info("Количество итераций: 1000");
        LOGGER.info("Погрешность: " + Math.abs(Math.PI - pi) + "\n");

        pi = MultithreadPICalculator.calculatePI(1_000_000, 6);
        LOGGER.info(pi);
        LOGGER.info("Количество итераций: 10^6");
        LOGGER.info("Погрешность: " + Math.abs(Math.PI - pi) + "\n");

        pi = MultithreadPICalculator.calculatePI(10_000_000, 6);
        LOGGER.info(pi);
        LOGGER.info("Количество итераций: 10^7");
        LOGGER.info("Погрешность: " + Math.abs(Math.PI - pi) + "\n");

        pi = MultithreadPICalculator.calculatePI(100_000_000, 6);
        LOGGER.info(pi);
        LOGGER.info("Количество итераций: 10^8");
        LOGGER.info("Погрешность: " + Math.abs(Math.PI - pi) + "\n");

        pi = MultithreadPICalculator.calculatePI(1_000_000_000, 6);
        LOGGER.info(pi);
        LOGGER.info("Количество итераций: 10^9");
        LOGGER.info("Погрешность: " + Math.abs(Math.PI - pi) + "\n");
    }
}
