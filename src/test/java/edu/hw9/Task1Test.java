package edu.hw9;

import edu.hw9.Task1.StatsCollector;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.concurrent.ExecutionException;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Task1Test {
    @Test
    @DisplayName("Многопоточная сборка статистики")
    public void multithreadedMetricTest() {
        StatsCollector collector = new StatsCollector(6);

        double[] dataSet1 = new double[] {1.0, 2.0, 3.0};
        double[] dataSet2 = new double[] {-44.2, 105.1, 0.0};
        double[] dataSet3 = new double[] {-3.0, 5.4423, -10.247};

        collector.push("sum", dataSet1);
        collector.push("avg", dataSet1);
        collector.push("min", dataSet1);
        collector.push("max", dataSet1);

        collector.push("sum", dataSet2);
        collector.push("avg", dataSet2);
        collector.push("min", dataSet2);
        collector.push("max", dataSet2);

        collector.push("sum", dataSet3);
        collector.push("avg", dataSet3);
        collector.push("min", dataSet3);
        collector.push("max", dataSet3);

        List<Double> statsActual = collector.getStats().stream()
            .map(f -> {
                try {
                    return f.get();
                } catch (InterruptedException | ExecutionException e) {
                    throw new RuntimeException(e);
                }
            }).toList();

        List<Double> statsExpected = List.of(
            6.0, 2.0, 1.0, 3.0,
            60.9, 20.3, -44.2, 105.1,
            -7.8047, -2.6015666, -10.247, 5.4423
        );

        for (int i = 0; i < statsActual.size(); i++) {
            assertTrue(doublesEquals(statsActual.get(i), statsExpected.get(i)));
        }
    }

    @Test
    @DisplayName("Фильтрация неправильных параметров")
    public void invalidParamsTest() {
        StatsCollector collector = new StatsCollector(6);

        double[] dataSet = new double[] {1.0, 2.0, 3.0};

        collector.push("СУММА", dataSet);
        collector.push("", dataSet);
        collector.push("sum", null);
        collector.push("sum", new double[0]);

        try {
            assertNull(collector.getStats().get(0).get());
            assertNull(collector.getStats().get(1).get());
            assertNull(collector.getStats().get(2).get());
            assertEquals(collector.getStats().get(3).get(), 0D);
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
    }

    private static boolean doublesEquals(double d1, double d2) {
        return Math.abs(d1 - d2) < 0.000001;
    }
}
