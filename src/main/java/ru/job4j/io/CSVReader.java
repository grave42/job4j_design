package ru.job4j.io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CSVReader {
    public static void handle(ArgsName argsName) throws Exception {
        String[] filters = argsName.get("filter").split(",");
        List<Integer> csvHeadsIndex = new ArrayList<>();
        try (FileInputStream fileInputStream = new FileInputStream(argsName.get("path"));
             Scanner scanner = new Scanner(fileInputStream);
             PrintWriter writer = new PrintWriter(new FileWriter(argsName.get("out")))) {
            if (scanner.hasNextLine()) {
                String firstLine = scanner.nextLine();
                List<String> cells = List.of(firstLine.split(argsName.get("delimiter")));
                for (String filter : filters) {
                    int index = cells.indexOf(filter);
                    if (index != -1) {
                        csvHeadsIndex.add(index);
                    }
                }
                if ("stdout".equals(argsName.get("out"))) {
                    System.out.println(String.join(argsName.get("delimiter"), filters));
                } else {
                    writer.println(String.join(argsName.get("delimiter"), filters));
                }


            }
            while (scanner.hasNextLine()) {
                String field = scanner.nextLine();
                List<String> res = List.of(field.split(argsName.get("delimiter")));
                List<String> resLine = new ArrayList<>();
                for (Integer ind : csvHeadsIndex) {
                    resLine.add(res.get(ind));
                }
                if ("stdout".equals(argsName.get("out"))) {
                    System.out.println(String.join(argsName.get("delimiter"), resLine));
                } else {
                    writer.println(String.join(argsName.get("delimiter"), resLine));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void valArgs(String[] args, ArgsName allArgs) {
        if (args.length != 4) {
            throw new IllegalArgumentException("Root folder is null. Usage  ROOT_FOLDER.");
        }
        File directory = new File(allArgs.get("path"));
        if (!directory.exists() && !directory.isDirectory()) {
            throw new IllegalArgumentException("First argument is not directory path");
        }
        if (!(allArgs.get("delimiter").length() == 1) || !";".equals(allArgs.get("delimiter"))) {
            throw new IllegalArgumentException("It is not CSV delimiter");
        }
    }

    public static void main(String[] args) throws Exception {
        ArgsName argsName = ArgsName.of(args);
        valArgs(args, argsName);
        handle(argsName);
    }
}

