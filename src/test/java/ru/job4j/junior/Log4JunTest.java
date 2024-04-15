package ru.job4j.junior;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


class Log4JunTest {
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    private final List<Appender> appenders = List.of(new ConsoleLogAppender());

    @Test
    public void testLoggerCreation() {
        Log4Jun logger = new Log4Jun(appenders, LogLevel.WARNING);
        assertNotNull(logger);
    }

    @Test
    public void testInfoLogMessage() {
        Log4Jun logger = new Log4Jun(appenders, LogLevel.INFO);
        logger.info("Test message");
        assertEquals(String.format("[%s] Test message", LogLevel.INFO), outputStreamCaptor.toString().trim());
    }

    @Test
    public void testDebugLogMessage() {
        Log4Jun logger = new Log4Jun(appenders, LogLevel.DEBUG);
        logger.debug("Test message");
        assertEquals(String.format("[%s] Test message", LogLevel.DEBUG), outputStreamCaptor.toString().trim());
    }

    @Test
    public void testLogWithMinLogLevel() {
        Log4Jun logger = new Log4Jun(appenders, LogLevel.WARNING);
        logger.debug("Debug message");
        logger.info("Info message");
        assertTrue(outputStreamCaptor.toString().trim().isEmpty());
        logger.error("Error message");
        assertEquals(String.format("[%s] Error message", LogLevel.ERROR), outputStreamCaptor.toString().trim());
    }

    @Test
    public void testSetMinLogLevel() {
        Log4Jun logger = new Log4Jun(appenders, LogLevel.INFO);
        logger.debug("Debug message");
        logger.setMinLogLevel(LogLevel.WARNING);
        logger.debug("Another debug message");
        assertTrue(outputStreamCaptor.toString().trim().isEmpty());
    }
}