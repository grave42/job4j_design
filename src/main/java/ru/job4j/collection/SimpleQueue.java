package ru.job4j.collection;

import java.util.NoSuchElementException;

public class SimpleQueue<T> {
    private final SimpleStack<T> in = new SimpleStack<>();
    private final SimpleStack<T> out = new SimpleStack<>();

    int sizeIn = 0;
    int sizeOut = 0;

    public T poll() {
        if (sizeOut == 0) {
            while (sizeIn != 0) {
                out.push(in.pop());
                sizeIn--;
                sizeOut++;
            }
        }
        sizeOut--;
        if (sizeOut < 0) {
            throw new NoSuchElementException("Queue is empty");
        }
        return out.pop();
    }

    public void push(T value) {
        in.push(value);
        sizeIn++;
    }
}
