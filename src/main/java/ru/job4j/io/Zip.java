package ru.job4j.io;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import static ru.job4j.io.Search.search;

public class Zip {

    public void packFiles(List<Path> sources, File target) {
        try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target)))) {
            for (Path source : sources) {
                File sourceFile = source.toFile();
                zip.putNextEntry(new ZipEntry(sourceFile.getPath()));
                try (BufferedInputStream out = new BufferedInputStream(new FileInputStream(sourceFile))) {
                    zip.write(out.readAllBytes());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void packSingleFile(File source, File target) {
        try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target)))) {
            zip.putNextEntry(new ZipEntry(source.getPath()));
            try (BufferedInputStream out = new BufferedInputStream(new FileInputStream(source))) {
                zip.write(out.readAllBytes());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void valArgs(String[] args, ArgsName allArgs) {
        if (args.length != 3) {
            throw new IllegalArgumentException("Root folder is null. Usage  ROOT_FOLDER.");
        }
        File directory = new File(allArgs.get("d"));
        if (!directory.exists() && !directory.isDirectory()) {
            throw new IllegalArgumentException("First argument is not directory path");
        }
        if (allArgs.get("e").length() <= 1 || !allArgs.get("e").startsWith(".")) {
            throw new IllegalArgumentException("Second argument is not file extension ");
        }
        if (!allArgs.get("o").endsWith(".zip")) {
            throw new IllegalArgumentException("Archive format is not ZIP");
        }
    }

    public static void main(String[] args) throws IOException {
        Zip zip = new Zip();
        zip.packSingleFile(
                new File("./pom.xml"),
                new File("./pom.zip")
        );
        ArgsName allArgs = ArgsName.of(args);
        valArgs(args, allArgs);
        List<Path> sources = search(Paths.get(allArgs.get("d")), p -> !p.toFile().getName().endsWith(allArgs.get("e")));
        zip.packFiles(sources, new File(allArgs.get("o")));
    }
}
