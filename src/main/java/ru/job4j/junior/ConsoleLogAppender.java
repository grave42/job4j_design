package ru.job4j.junior;

public class ConsoleLogAppender implements Appender {
    @Override
    public void append(String message) {
        System.out.println(message);
    }
}