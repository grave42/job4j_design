package ru.job4j.question;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Analize {

    public static Info diff(Set<User> previous, Set<User> current) {
        int added = 0;
        int chenged = 0;
        int deleted = 0;
        Map<Integer, User> prevMap = new HashMap<>();
        Map<Integer, User> currMap = new HashMap<>();

        for (User user : previous) {
            prevMap.put(user.getId(), user);
        }

        for (User user : current) {
            currMap.put(user.getId(), user);
        }

        for (User user : current) {
            User prevUser = prevMap.get(user.getId());
            if (prevUser == null) {
                added++;
            } else if (!prevUser.equals(user)) {
                chenged++;
            }
        }

        for (User user : previous) {
            if (!currMap.containsKey(user.getId())) {
                deleted++;
            }
        }

        return new Info(added, chenged, deleted);
    }
}