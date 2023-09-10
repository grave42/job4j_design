package ru.job4j.iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class Balancer {
    public static void split(List<ArrayList<Integer>> nodes, Iterator<Integer> source) {
        while (source.hasNext()) {
            for (ArrayList<Integer> node : nodes) {
                try {
                    node.add(source.next());
                } catch (NoSuchElementException e) {
                    break;
                }
            }
        }
    }
}