package ru.job4j.map;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class NonCollisionMap<K, V> implements SimpleMap<K, V> {

    private static final float LOAD_FACTOR = 0.75f;

    private int capacity = 8;

    private int count = 0;

    private int modCount = 0;

    private MapEntry<K, V>[] table = new MapEntry[capacity];

    @Override
    public boolean put(K key, V value) {
        if ((float) count / capacity >= LOAD_FACTOR) {
            expand();
        }
        int hk = Objects.hashCode(key);
        int index = indexFor(hash(hk));
        if (table[index] == null) {
            table[index] = new MapEntry<>(key, value);
            count++;
            modCount++;
            return true;
        }
        return false;
    }

    private int hash(int hashCode) {
        return (hashCode == 0) ? 0 : hashCode ^ (hashCode >>> 16);
    }

    private int indexFor(int hash) {
        return hash & (table.length - 1);
    }

    private void expand() {
        MapEntry<K, V>[] newTable = new MapEntry[capacity * 2];
        for (MapEntry<K, V> entry : table) {
            if (entry != null) {
                int hk = Objects.hashCode(entry.key);
                int index = indexFor(hash(hk));
                newTable[index] = new MapEntry<>(entry.key, entry.value);
            }
        }
        table = newTable;
    }

    private int getIndex(K key) {
        return indexFor(hash(Objects.hashCode(key)));
    }

    private boolean hashAndEuqals(K key) {
        int index = getIndex(key);
        return (table[index] != null && Objects.hashCode(table[index].key) == Objects.hashCode(key) && Objects.equals(key, table[index].key));
    }

    @Override
    public V get(K key) {
        if (hashAndEuqals(key)) {
            return table[getIndex(key)].value;
        }
        return null;
    }

    @Override
    public boolean remove(K key) {
        if (hashAndEuqals(key)) {
            table[getIndex(key)] = null;
            count--;
            modCount++;
            return true;
        }
        return false;
    }

    @Override
    public Iterator<K> iterator() {
        return new MapIterator();
    }

    private class MapIterator implements Iterator<K> {
        private int currentIndex = 0;
        private int expectedModCount = modCount;

        @Override
        public boolean hasNext() {
            checkForModification();
            while (table.length > currentIndex && table[currentIndex] == null) {
                currentIndex++;
            }
            return table.length > currentIndex;
        }

        @Override
        public K next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return table[currentIndex++].key;
        }

        private void checkForModification() {
            if (modCount != expectedModCount) {
                throw new ConcurrentModificationException();
            }
        }
    }


    private static class MapEntry<K, V> {

        K key;
        V value;

        public MapEntry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}