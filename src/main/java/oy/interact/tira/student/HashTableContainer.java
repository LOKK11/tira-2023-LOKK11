package oy.interact.tira.student;

import java.util.function.Predicate;

import oy.interact.tira.util.Pair;
import oy.interact.tira.util.TIRAKeyedContainer;

public class HashTableContainer<K extends Comparable<K>,V> implements TIRAKeyedContainer<K,V> {
    
    private Pair<K,V>[] array;
    private int size = 0;
    private final int DEFAULT_SIZE = 20;

    @Override
    public void add(K key, V value) throws OutOfMemoryError, IllegalArgumentException {
        if (key == null || value == null) {
            throw new IllegalArgumentException("Key and value must not be null.");
        }
        try {
            for (int i = 0; i < array.length - 1; ++i) {
                int hashIndex = hashFunc(key, i);
                if (array[hashIndex] == null) {
                    // Found an empty slot or a slot marked as removed, insert the pair
                    array[hashIndex] = new Pair<>(key, value);
                    ++size;
                    return;
                } else if (array[hashIndex].getKey().equals(key)) {
                    // Key already exists, update the value
                    if (array[hashIndex].isRemoved()) {
                        array[hashIndex].setRemoved(false); // Restoring if it was previously removed                    
                        ++size;    
                    }
                    array[hashIndex].setValue(value);
                    return;
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

    @Override
    public V get(K key) throws IllegalArgumentException {
        if (key == null) {
            throw new IllegalArgumentException("Key value cannot be null.");
        }
        int i = 0;
        int hashIndex = hashFunc(key, i);
        while (i < array.length - 1 && array[hashIndex] != null) {
            if (array[hashIndex].getKey().equals(key)) {
                return array[hashIndex].getValue();
            }
            ++i;
            if (i < array.length - 1) {
                hashIndex = hashFunc(key, i);
            }
        }
        return null;
    }

    @Override
    public V remove(K key) throws IllegalArgumentException {
        if (key == null) {
            throw new IllegalArgumentException("Key value cannot be null.");
        }
        int i = 0;
        int hashIndex = hashFunc(key, i);
        while (i < array.length - 1 && array[hashIndex] != null) {
            if (array[hashIndex].getKey().equals(key)) {
                array[hashIndex].setRemoved(true);
                --size;
                return array[hashIndex].getValue();
            }
            ++i;
            if (i < array.length - 1) {
                hashIndex = hashFunc(key, i);
            }
        }
        return null;
    }

    @Override
    public V find(Predicate<V> searcher) {
        for (int i = 0; i < array.length; ++i) {
            if (searcher.test(array[i].getValue())) {
                return array[i].getValue();
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public int capacity() {
        return array.length;
    }

    @Override
    @SuppressWarnings("unchecked")
    public void ensureCapacity(int capacity) throws OutOfMemoryError, IllegalArgumentException {
        if (capacity <= size) {
            throw new IllegalArgumentException("Capacity cannot be less than current size of the table");
        }
        try {
            Pair<K,V>[] tempArray = array;
            array = new Pair[capacity];
            for (int i = 0; i < array.length; ++i) {
                if (tempArray[i] != null) {
                    add(tempArray[i].getKey(), tempArray[i].getValue());
                }
            }
            

        } catch (OutOfMemoryError e) {
            throw new OutOfMemoryError("System ran out of memory during allocation");
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public void clear() {
        array = new Pair[DEFAULT_SIZE];
        size = 0;
    }

    @Override
    public Pair<K,V> [] toArray() throws Exception {
        return array;
    }
}
