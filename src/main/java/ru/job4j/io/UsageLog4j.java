package ru.job4j.io;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UsageLog4j {

    private static final Logger LOG = LoggerFactory.getLogger(UsageLog4j.class.getName());

    public static void main(String[] args) {
        String name = "Petr Arsentev";
        int age = 33;
        byte space = 56;
        short space2 = 10000;
        long space3 = 66666;
        float fl = 2.0F;
        double db = 1.0D;
        boolean ex = true;
        char ch = 'A';
        LOG.info("This is byte: {}, this is short: {}, this is long: {}", space, space2, space3);
        LOG.error("This is float: {}, this is double: {}", fl, db);
        LOG.debug("User info name : {}, age : {}", name, age);
        LOG.debug("This is boolean: {}, this is char: {}", ex, ch);
    }
}
