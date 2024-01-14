package ru.job4j.spammer;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class ImportDB {

    private Properties config;
    private String dump;

    public ImportDB(Properties config, String dump) {
        this.config = config;
        this.dump = dump;
    }

    public List<User> load() throws IOException {
        List<User> users = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(dump))) {
            reader.lines().forEach(line -> {
                String[] userData = line.split(";");
                if (userData.length == 2 && !userData[0].isEmpty() && !userData[1].isEmpty()) {
                    users.add(new User(userData[0], userData[1]));
                } else {
                    throw new IllegalArgumentException("Некорректные данные в строке: " + line);
                }
            });
        }
        return users;
    }

    public void save(List<User> users) throws ClassNotFoundException, SQLException {
        Class.forName(config.getProperty("driver_class"));
        try (Connection connection = DriverManager.getConnection(
                config.getProperty("url_db"),
                config.getProperty("login_db"),
                config.getProperty("password_db")
        )) {
            for (User user : users) {
                try (PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO users (name, email) values (?, ?)")) {
                    preparedStatement.setString(1, user.name);
                    preparedStatement.setString(2, user.email);
                    preparedStatement.execute();
                }
            }
        }
    }

    private static class User {
        String name;
        String email;

        public User(String name, String email) {
            this.name = name;
            this.email = email;
        }
    }


    public static void main(String[] args) throws Exception {
        Properties config = new Properties();
        try (InputStream input = ImportDB.class.getClassLoader().getResourceAsStream("app.properties")) {
            config.load(input);
        }
        ImportDB dataBase = new ImportDB(config, "./dump.txt");
        dataBase.save(dataBase.load());
    }
}