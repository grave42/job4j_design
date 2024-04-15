package ru.job4j.junior;

import java.util.ArrayList;
import java.util.List;

public class Log4Jun implements LoggerInterface {

    private List<Appender> appenders;
    private LogLevel minLogLevel;

    public Log4Jun(List<Appender> appenders, LogLevel minLogLevel) {
        this.appenders = appenders;
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
            appenders.forEach(appender -> appender.append(formattedMessage));
        }
    }

    @Override
    public void log(String message) {
        appenders.forEach(appender -> appender.append(message));
    }

    public void setMinLogLevel(LogLevel minLogLevel) {
        this.minLogLevel = minLogLevel;
    }
}
