package ru.job4j.io.duplicates;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class DuplicatesVisitor extends SimpleFileVisitor<Path> {
    private final Map<FileProperty, List<Path>> filesMap = new HashMap<>();

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        if (!attrs.isDirectory()) {
            FileProperty property = new FileProperty(attrs.size(), file.getFileName().toString());
            if (filesMap.containsKey(property)) {
                filesMap.get(property).add(file.toAbsolutePath());
            } else {
                List<Path> paths = new LinkedList<>();
                paths.add(file.toAbsolutePath());
                filesMap.put(property, paths);
            }
        }
        return FileVisitResult.CONTINUE;
    }

    public void printDuplicates() {
        for (Map.Entry<FileProperty, List<Path>> entry : filesMap.entrySet()) {
            List<Path> paths = entry.getValue();
            if (paths.size() > 1) {
                System.out.println("Дубликаты файла " + entry.getKey().getName() + " - " + entry.getKey().getSize() + " bytes:");
                for (Path path : paths) {
                    System.out.println(path);
                }
            }
        }
    }
}