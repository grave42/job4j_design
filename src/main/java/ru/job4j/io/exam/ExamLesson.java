package ru.job4j.io.exam;

import ru.job4j.io.ArgsName;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.function.Predicate;

import static ru.job4j.io.Search.search;

public class ExamLesson {

    private static Predicate<Path> prMaker(String name, String arg) {
        Predicate<Path> result = null;
        if (name.equals("mask")) {
            String mask = arg.replace(".", "\\.").replace("?", ".").replace("*", ".*");
            result = path -> {
                String fileName = path.toFile().getName();
                return fileName.matches(mask);
            };
        }
        if (name.equals("name")) {
            result = path -> {
                String fileName = path.toFile().getName();
                return fileName.equals(arg);
            };
        }
        if (name.equals("regex")) {
            result = path -> {
                String fileName = path.toFile().getName();
                return fileName.matches(arg);
            };
        }
        return result;
    }

    private static void valArgs(String[] args, ArgsName allArgs) {
        if (args.length != 4) {
            throw new IllegalArgumentException("Need to set 4 args: -d -n -t -o");
        }
        File directory = new File(allArgs.get("d"));
        if (!directory.exists() && !directory.isDirectory()) {
            throw new IllegalArgumentException("First argument -d is not directory path");
        }

        if (!allArgs.get("t").equals("mask") && !allArgs.get("t").equals("name") && !allArgs.get("t").equals("regex")) {
            throw new IllegalArgumentException("Third argument -t can be \"name\", \"mask\" or \"regex\"");
        }
    }

    public static void main(String[] args) throws IOException {
        ArgsName allArgs = ArgsName.of(args);
        valArgs(args, allArgs);
        Path start = Paths.get(allArgs.get("d"));
        try (FileOutputStream fos = new FileOutputStream(allArgs.get("o"))) {
            Predicate<Path> p = prMaker(allArgs.get("t"), allArgs.get("n"));
            List<Path> result = search(start, p);
            result.forEach(path -> {
                try {
                    String data = path.toString() + "\n";
                    fos.write(data.getBytes());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
