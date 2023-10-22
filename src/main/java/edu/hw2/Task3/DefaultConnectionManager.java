package edu.hw2.Task3;

public class DefaultConnectionManager implements ConnectionManager {
    private final double stableConnectionChance = 0.8;

    @Override
    public Connection getConnection() {
        if (Math.random() < stableConnectionChance) {
            return new StableConnection();
        } else {
            return new FaultyConnection();
        }
    }
}
