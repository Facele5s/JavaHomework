package edu.hw2.Task3;

public final class PopularCommandExecutor {
    private final ConnectionManager manager;
    private final int maxAttempts;
    private final String error = "Error";
    private final double defaultConnectionChance = 0.5;

    public PopularCommandExecutor(int maxAttempts) {
        if (Math.random() < defaultConnectionChance) {
            manager = new DefaultConnectionManager();
        } else {
            manager = new FaultyConnectionManager();
        }
        this.maxAttempts = maxAttempts;
    }

    public void updatePackages() throws Exception {
        tryExecute("apt update && apt upgrade -y");
    }

    public void tryExecute(String command) throws Exception {
        Connection connection = manager.getConnection();
        boolean commandExecuted = false;

        if (maxAttempts == 0) {
            throw new ConnectionException(error, new RuntimeException());
        }

        for (int i = 1; i <= maxAttempts && !commandExecuted; i++) {
            try {
                connection.execute(command);
                commandExecuted = true;
            } catch (ConnectionException e) {
                commandExecuted = false;
                if (i == maxAttempts) {
                    throw new ConnectionException(error, new RuntimeException());
                }
            }
        }

        connection.close();
    }
}
