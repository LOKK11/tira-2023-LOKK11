package oy.interact.tira.student;

import java.util.function.Predicate;

import oy.interact.tira.util.TIRAKeyedOrderedContainer;

public class BinaryTree<K extends Comparable<K>, V> implements TIRAKeyedOrderedContainer<K, V> {
    
    Node<K,V> root;

    @Override
    public void add(K key, V value) throws OutOfMemoryError, IllegalArgumentException {
        if (key == null || value == null) {
            throw new IllegalArgumentException("Key and value should not be null.");
        }
        Node<K,V> node = new Node<>(key, value);
        if (root == null) {
            root = node;
        } else {
            root.add(node);
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
            return root.remove(key);
        } 
    }

    public V find(Predicate<V> searcher) {
        if (root == null) {
            return null;
        } else {
            return root.find(searcher);
        }
    }
}
