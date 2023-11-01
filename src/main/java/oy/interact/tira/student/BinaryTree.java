package oy.interact.tira.student;

import java.util.Comparator;
import java.util.function.Predicate;

import oy.interact.tira.util.Pair;
import oy.interact.tira.util.TIRAKeyedOrderedContainer;

public class BinaryTree<K extends Comparable<K>, V> implements TIRAKeyedOrderedContainer<K, V> {
    
    private Node<K,V> root = null;
    private int size = 0;
    private Comparator<K> comparator;
    private int capacity = Integer.MAX_VALUE;
    private Object[] array;
    private int addedToArray = 0;

    public BinaryTree(Comparator<K> comparator) {
        this.comparator = comparator;
    }

    @Override
    public void add(K key, V value) throws OutOfMemoryError, IllegalArgumentException {
        if (key == null || value == null) {
            throw new IllegalArgumentException("Key and value should not be null.");
        }
        Node<K,V> node = new Node<>(key, value);
        if (root == null) {
            root = node;
        } else if (size < capacity) {
            root.add(node);
            ++size;
        }
    }

    @Override
    public V get(K key) throws IllegalArgumentException {
        if (key == null) {
            throw new IllegalArgumentException("Key cannot be null.");
        }
        if (root == null) {
            return null;
        } else {
            return root.get(key);
        }
    }

    @Override
    public V remove(K key) throws IllegalArgumentException {
        if (key == null) {
            throw new IllegalArgumentException("Key cannot be null.");
        }
        if (root == null) {
            return null;
        } else {
            V tempValue = root.remove(root, key);
            if (tempValue != null) {
                --size;
            }
            return tempValue;
        } 
    }

    public V find(Predicate<V> searcher) {
        if (root == null) {
            return null;
        } else {
            return root.find(searcher);
        }
    }

    public int size() {
        return size;
    }

    public int capacity() {
        return capacity;
    }

    public void ensureCapacity(int capacity) throws OutOfMemoryError, IllegalArgumentException {
        if (capacity <= size()) {
            throw new IllegalArgumentException("Capacity cannot less than the amount of pairs currently on tree.");
        }
        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity cannot be less than 1");
        }
        this.capacity = capacity;
    }

    public void clear() {
        root = null;
        size = 0;
    }

    @SuppressWarnings("unchecked")
    public Pair<K,V> [] toArray() throws Exception {
        if (root != null) {
            addedToArray = 0;
            array = new Object[size];
            makeArray(root);
            return (Pair<K, V>[]) array;
        }
        return null;
    }

    public void makeArray(Node<K,V> node) {
        if (node.getLeft() != null) {
            makeArray(node.getLeft());
        }
        Pair<K,V> pair = new Pair<>(node.getKey(), node.getValue());
        addToArray(pair);
        if (node.getRight() != null) {
            makeArray(node.getRight());
        }
    }

    public void addToArray(Pair<K,V> pair) {
        array[++addedToArray - 1] = pair;
    }

    public int indexOf(K itemKey) {
        if (root != null) {
            return root.indexOf(itemKey);
        }
        return -1;
    }
}
