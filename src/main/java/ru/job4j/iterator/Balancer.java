package ru.job4j.iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class Balancer {
    public static void split(List<ArrayList<Integer>> nodes, Iterator<Integer> source) {
        int nodeIndex = 0;
        while (source.hasNext()) {
            if (nodeIndex >= nodes.size()) {
                nodeIndex = 0;
            }
            nodes.get(nodeIndex).add(source.next());
            nodeIndex++;
        }
    }
}