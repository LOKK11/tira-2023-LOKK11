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
                int hashIndex = hashProbe(key, i);
                if (array[hashIndex] == null) {
                    array[hashIndex] = new Pair<K,V>(key, value);
                } else if (array[hashIndex].getKey().equals(key)) {
                    array[hashIndex].setValue(value);
                }
            }
            throw new IndexOutOfBoundsException("Index of hash went over the size of the array.");
        } catch (OutOfMemoryError outOfMemoryError) {
            throw new OutOfMemoryError("Memory ran out while adding an element.");
        }
    }

    private int hashProbe(K key, int i) {
        int hashValue = key.hashCode();
        int hashIndex = ((hashValue + i) & 0x7fffffff) % array.length;
        return hashIndex;
    }
}
