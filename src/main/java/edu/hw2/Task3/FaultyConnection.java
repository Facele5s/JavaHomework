package edu.hw2.Task3;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class FaultyConnection implements Connection {
    private final Logger logger = LogManager.getLogger();
    private final double exceptionChance = 0.5;

    @Override
    public void execute(String command) throws ConnectionException {
        if (Math.random() < exceptionChance) {
            throw new ConnectionException(ERROR, new RuntimeException());
        }
        logger.info(command + SUCCESS);
    }

    @Override
    public void close() {
        logger.info(this.getClass().getName() + CLOSED);
    }
}
