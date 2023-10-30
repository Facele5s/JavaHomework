package edu.hw2.Task3;

public class DefaultConnectionManager implements ConnectionManager {
    private final double stableConnectionManager = 0.8;

    @Override
    public Connection getConnection() {
        if (Math.random() < stableConnectionManager) {
            return new StableConnection();
        }
        return new FaultyConnection();
    }
}
