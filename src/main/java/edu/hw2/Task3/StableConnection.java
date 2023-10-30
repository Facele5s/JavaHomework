package edu.hw2.Task3;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class StableConnection implements Connection {
    private final Logger logger = LogManager.getLogger();

    @Override
    public void execute(String command) {
        logger.info(command + SUCCESS);
    }

    @Override
    public void close() {
        logger.info(this.getClass().getName() + CLOSED);
    }
}
