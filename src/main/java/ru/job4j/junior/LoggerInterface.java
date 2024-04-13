package ru.job4j.junior;

import java.util.List;

public interface LoggerInterface {
    void debug(String message);

    void info(String message);

    void warning(String message);

    void error(String message);

    void log(String message);

    List<String> getLogs();

    void clearLogs();
}
