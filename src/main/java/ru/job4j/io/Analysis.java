package ru.job4j.io;

import java.io.*;

public class Analysis {
    public void unavailable(String source, String target) {
        try (BufferedReader read = new BufferedReader(new FileReader(source));
             BufferedWriter write = new BufferedWriter(new FileWriter(target, true))) {
            StringBuilder currentRange = new StringBuilder();
            String line;
            while ((line = read.readLine()) != null) {
                String[] parts = line.split(" ");
                if (("400".equals(parts[0]) || "500".equals(parts[0])) && currentRange.length() == 0) {
                    currentRange.append(parts[1]).append(";");
                } else if (currentRange.length() > 0 && ("200".equals(parts[0]) || "300".equals(parts[0]))) {
                    currentRange.append(parts[1]).append(";\n");
                    write.write(currentRange.toString());
                    currentRange.setLength(0);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Analysis analysis = new Analysis();
        analysis.unavailable("data/server.log", "data/target.csv");
    }
}
