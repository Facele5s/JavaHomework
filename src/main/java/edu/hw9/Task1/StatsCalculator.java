package edu.hw9.Task1;

import java.util.Arrays;

public class StatsCalculator {

    private StatsCalculator() {

    }

    public static Double getMetric(String metricType, double[] data) {
        return switch (metricType.toLowerCase()) {
            case "sum" -> getSum(data);
            case "avg" -> getAverage(data);
            case "min" -> getMin(data);
            case "max" -> getMax(data);
            default -> null;
        };
    }

    public static Double getSum(double[] data) {
        return Arrays.stream(data).sum();
    }

    public static Double getAverage(double[] data) {
        return Arrays.stream(data).average().orElseThrow();
    }

    public static Double getMin(double[] data) {
        return Arrays.stream(data).min().orElseThrow();
    }

    public static Double getMax(double[] data) {
        return Arrays.stream(data).max().orElseThrow();
    }
}
