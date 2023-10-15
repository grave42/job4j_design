package ru.job4j.io;

import java.io.*;

public class Analysis {
    public void unavailable(String source, String target) {
        try (BufferedReader read = new BufferedReader(new FileReader(source));
             BufferedWriter write = new BufferedWriter(new FileWriter(target, true))) {
            String currentRange = null;
            String line;
            while ((line = read.readLine()) != null) {
                String[] parts = line.split(" ");
                if ((parts[0].equals("400") || parts[0].equals("500")) && currentRange == null) {
                    currentRange = parts[1] + ";";
                } else if (currentRange != null && (parts[0].equals("200") || parts[0].equals("300"))) {
                    currentRange += parts[1] + ";\n";
                    write.write(currentRange);
                    currentRange = null;
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
