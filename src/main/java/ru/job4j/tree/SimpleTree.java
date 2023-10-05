package ru.job4j.tree;

import java.util.*;
import java.util.function.Predicate;

public class SimpleTree<E> implements Tree<E> {
    private final Node<E> root;

    public SimpleTree(final E root) {
        this.root = new Node<>(root);
    }

    private Optional<Node<E>> findByPredicate(Predicate<Node<E>> condition) {
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(this.root);
        while (!data.isEmpty()) {
            Node<E> el = data.poll();
            if (condition.test(el)) {
                return Optional.of(el);
            }
            data.addAll(el.children);
        }
        return Optional.empty();
    }

    private Predicate<Node<E>> findByValuePredicate(E value) {
        return node -> node.value.equals(value);
    }

    private Predicate<Node<E>> isBinaryPredicate() {
        return node -> node.children.size() > 2;
    }

    @Override
    public boolean isBinary() {
        return findByPredicate(isBinaryPredicate()).isEmpty();
    }

    @Override
    public boolean add(E parent, E child) {
        Optional<Node<E>> findedNode = findBy(parent);
        boolean rsl = findedNode.isPresent() && findBy(child).isEmpty();
        if (rsl) {
            findedNode.get().children.add(new Node<>(child));
        }
        return rsl;
    }

    @Override
    public Optional<Node<E>> findBy(E value) {
        return findByPredicate(findByValuePredicate(value));
    }
}
