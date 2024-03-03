package ru.job4j.cache.menu;

import ru.job4j.cache.DirFileCache;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.stream.Stream;

public class Emulator {

    public static final Integer SET_DIR = 1;
    public static final Integer LOAD_CACHE = 2;
    public static final Integer GET_CACHE = 3;

    public static final String EXIT = "Конец работы";

    public static final String MENU = """
                Введите 1. Указать кэшируемую директорию
                Введите 2. Загрузить содержимое файла в кэш
                Введите 3. Получить содержимое файла из кэша
                Введите любое другое число для выхода.
            """;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DirFileCache absDir = new DirFileCache("");
        start(scanner, absDir);
    }

    private static void start(Scanner scanner, DirFileCache absDir) {
        boolean run = true;
        while (run) {
            System.out.println(MENU);

            int userChoice = Integer.parseInt(scanner.nextLine());
            System.out.println(userChoice);
            if (userChoice == SET_DIR) {
                System.out.println("Введите относительный путь для дирректории");
                String userDir = scanner.nextLine();
                absDir.setCachingDir(userDir);
            } else if (userChoice == LOAD_CACHE) {
                Path directory = Paths.get(absDir.getCachingDir());
                try (Stream<Path> paths = Files.walk(directory)) {
                    paths.filter(Files::isRegularFile).filter(p -> p.toString().endsWith(".txt")).map(Path::getFileName).map(Path::toString).forEach(fileName -> {
                        absDir.loadCache(fileName);
                    });
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

            } else if (userChoice == GET_CACHE) {
                System.out.println("Введите имя файла");
                String userFile = scanner.nextLine();
                System.out.println(absDir.get(userFile));
            } else {
                run = false;
                System.out.println(EXIT);
            }
        }
    }
}
