package ru.job4j.junior;

import java.util.ArrayList;
import java.util.List;

public class Log4Jun implements LoggerInterface {

    private final List<String> logs;
    private Appender appender;
    private LogLevel minLogLevel;

    public Log4Jun(Appender appender, LogLevel minLogLevel) {
        this.logs = new ArrayList<>();
        this.appender = appender;
        this.minLogLevel = minLogLevel;
    }

    @Override
    public void debug(String message) {
        logWithLevel(LogLevel.DEBUG, message);
    }

    @Override
    public void info(String message) {
        logWithLevel(LogLevel.INFO, message);
    }

    @Override
    public void warning(String message) {
        logWithLevel(LogLevel.WARNING, message);
    }

    @Override
    public void error(String message) {
        logWithLevel(LogLevel.ERROR, message);
    }

    private void logWithLevel(LogLevel level, String message) {
        if (level.ordinal() >= minLogLevel.ordinal()) {
            String formattedMessage = String.format("[%s] %s", level.name(), message);
            logs.add(formattedMessage);
            appender.append(formattedMessage);
        }
    }

    @Override
    public void log(String message) {
        logs.add(message);
        appender.append(message);
    }

    public void setMinLogLevel(LogLevel minLogLevel) {
        this.minLogLevel = minLogLevel;
    }
}
