package ru.job4j.io.encoding;

import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class ConsoleChat {
    private static final String OUT = "закончить";
    private static final String STOP = "стоп";
    private static final String CONTINUE = "продолжить";
    private final String path;
    private final String botAnswers;

    public ConsoleChat(String path, String botAnswers) {
        this.path = path;
        this.botAnswers = botAnswers;
    }

    public void run() {
        List<String> allPhrases = readPhrases();
        Random random = new Random();
        boolean isRuning = true;
        boolean respondToInput = true;
        Scanner scanner = new Scanner(System.in);
        List<String> logfile = new ArrayList<>();
        while (isRuning) {
            int randomIndex = random.nextInt(allPhrases.size());
            String randomAnswer = allPhrases.get(randomIndex);
            String userInput = scanner.nextLine();
            logfile.add(userInput);
            if (OUT.equals(userInput)) {
                logfile.add(OUT);
                scanner.close();
                isRuning = false;
            } else if (STOP.equals(userInput)) {
                respondToInput = false;
                logfile.add(STOP);
            } else if (CONTINUE.equals(userInput)) {
                respondToInput = true;
                logfile.add(CONTINUE);
            } else if (respondToInput) {
                System.out.println(randomAnswer);
                logfile.add(randomAnswer);
            }
        }
        saveLog(logfile);
    }

    private List<String> readPhrases() {
        List<String> answers = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(botAnswers));
            String line;
            while ((line = reader.readLine()) != null) {
                answers.add(line);
            }
            reader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return answers;
    }

    private void saveLog(List<String> log) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(path, Charset.forName("WINDOWS-1251"), true))) {
            log.forEach(writer::println);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        ConsoleChat cc = new ConsoleChat("./data/log.txt", "./data/answers.txt");
        cc.run();
    }
}