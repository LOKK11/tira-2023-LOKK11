package oy.interact.tira.student;

import oy.interact.tira.util.Pair;
import oy.interact.tira.util.TIRAKeyedContainer;

public class HashTableContainer<K extends Comparable<K>,V> implements TIRAKeyedContainer<K,V> {
    
    private Pair<K,V>[] array;

    @Override
    public void add(K key, V value) throws OutOfMemoryError, IllegalArgumentException {
        if (key == null || value == null) {
            throw new IllegalArgumentException("Key and value must not be null.");
        }
        try {
            for (int i = 0; i < array.length - 1; ++i) {
                int hashIndex = hashFunc(key, i);
                if (array[hashIndex] != null) {
                    
                } 
            }
            throw new IndexOutOfBoundsException("Index of hash went over the size of the array.");
        } catch (OutOfMemoryError outOfMemoryError) {
            throw new OutOfMemoryError("Memory ran out while adding an element.");
        }
    }

    private int hashFunc(K key, int i) {
        int hashValue = key.hashCode();
        int hashIndex = ((hashValue + i) & 0x7fffffff) % array.length;
        return hashIndex;
    }

    public V get(K key) throws IllegalArgumentException {
        if (key == null) {
            throw new IllegalArgumentException("Key value cannot be null.");
        }
        int i = 0;
        int hashIndex = hashFunc(key, i);
        while (i < array.length - 1 && array[hashIndex] != null) {
            if (array[hashIndex].getKey() == key) {
                return array[hashIndex].getValue();
            }
            ++i;
            if (i < array.length - 1) {
                hashIndex = hashFunc(key, i);
            }
        }
        return null;
    }

    public V remove(K key) throws IllegalArgumentException {
        if (key == null) {
            throw new IllegalArgumentException("Key value cannot be null.");
        }
        int i = 0;
        int hashIndex = hashFunc(key, i);
        while (i < array.length - 1 && array[hashIndex] != null) {
            if (array[hashIndex].getKey() == key) {
                array[hashIndex].setRemoved();
                return array[hashIndex].getValue();
            }
            ++i;
            if (i < array.length - 1) {
                hashIndex = hashFunc(key, i);
            }
        }
        return null;
    }
}
