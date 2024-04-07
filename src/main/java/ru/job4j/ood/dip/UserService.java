package ru.job4j.ood.dip;

/**
 * UserService напрямую зависит от MySQLDatabase,
 * что делает код зависимым от конкретной реализации базы данных.
 */
public class UserService {
    private MySQLDatabase database = new MySQLDatabase();

    public void saveUser(User user) {
        database.save(user);
    }
}

class MySQLDatabase {

    public void save(User user) {

    }
}

class User {

}




