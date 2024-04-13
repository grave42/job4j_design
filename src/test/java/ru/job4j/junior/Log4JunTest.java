package ru.job4j.junior;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;


class Log4JunTest {

    @Test
    public void testLoggerCreation() {
        Log4Jun logger = new Log4Jun(new ConsoleLogAppender(), LogLevel.WARNING);
        assertNotNull(logger);
    }

    @Test
    public void testInfoLogMessage() {
        Log4Jun logger = new Log4Jun(new ConsoleLogAppender(), LogLevel.INFO);
        logger.info("Test message");
        assertTrue(logger.getLogs().contains("[INFO] Test message"));
    }

    @Test
    public void testDebugLogMessage() {
        Log4Jun logger = new Log4Jun(new ConsoleLogAppender(), LogLevel.DEBUG);
        logger.debug("Test message");
        assertTrue(logger.getLogs().contains("[DEBUG] Test message"));
    }

    @Test
    public void testClearLogs() {
        Log4Jun logger = new Log4Jun(new ConsoleLogAppender(), LogLevel.INFO);
        logger.warning("Test message");
        logger.clearLogs();
        assertTrue(logger.getLogs().isEmpty());
    }

    @Test
    public void testLogWithMinLogLevel() {
        Log4Jun logger = new Log4Jun(new ConsoleLogAppender(), LogLevel.WARNING);
        logger.debug("Debug message");
        logger.info("Info message");
        assertTrue(logger.getLogs().isEmpty());
        logger.error("Error message");
        assertTrue(logger.getLogs().contains("[ERROR] Error message"));
    }

    @Test
    public void testSetMinLogLevel() {
        Log4Jun logger = new Log4Jun(new ConsoleLogAppender(), LogLevel.INFO);
        logger.debug("Debug message");
        logger.setMinLogLevel(LogLevel.WARNING);
        logger.debug("Another debug message");
        assertTrue(logger.getLogs().isEmpty()); // Debug сообщение не должно быть записано после установки минимального уровня WARNING
    }
}

