package ru.job4j.generics;

import java.util.ArrayList;
import java.util.List;

public class Lesson {
    public static void main(String[] args) {
        List rawlist = new ArrayList();
        List<String> list = new ArrayList<>();

        rawlist = list;
        rawlist.add(8);
        String s = list.get(0);
    }
}
