package ru.job4j.collection;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class RevertLinked<T> implements Iterable<T> {
    private Node<T> head;

    public void add(T value) {
        Node<T> node = new Node<T>(value, null);
        if (head == null) {
            head = node;
            return;
        }
        Node<T> tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }
        tail.next = node;
    }

    public boolean revert() {
        boolean res = false;
        if (head == null  || head.next == null) {
            res = false;
        } else {
            Node<T> current = head;
            Node<T> prev = null;
            while (current != null) {
                Node<T> after = current.next;
                current.next = prev;
                prev = current;
                current = after;
            }
            head = prev;
            res = true;
        }
        return res;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            Node<T> node = head;

            @Override
            public boolean hasNext() {
                return node != null;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                T value = node.value;
                node = node.next;
                return value;
            }
        };
    }

    private static class Node<T> {
        T value;
        Node<T> next;

        public Node(T value, Node<T> next) {
            this.value = value;
            this.next = next;
        }
    }
}
