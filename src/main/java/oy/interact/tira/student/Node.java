package oy.interact.tira.student;

import java.util.function.Predicate;

public class Node<K extends Comparable<K>, V> {
    K key;
    V value;
    Node<K,V> left;
    Node<K,V> right;
    
    public Node(K key, V value) {
        this.key = key;
        this.value = value;
        left = null;
        right = null;
    }

    public void add(Node<K,V> node) {
        if (node.getKey().compareTo(key) < 0) {
            if (left == null) {
                left = node;
            } else {
                left.add(node);
            } 
        } else if (node.getKey().compareTo(key) > 0) {
            if (right == null) {
                right = node;
            } else {
                right.add(node);
            }             
        } else {
            this.value = node.getValue();
        }
    }

    public V get(K key) {
        if (this.key.compareTo(key) < 0) {
            if (left == null) {
                return null;
            } else {
                return left.get(key);
            } 
        } else if (this.key.compareTo(key) > 0) {
            if (right == null) {
                return null;
            } else {
                 return right.get(key);
            }
        } else {
            return value;
        }
    }

    public V find(Predicate<V> searcher) {
        if (searcher.compareTo(key) < 0) {
            if (left == null) {
                return null;
            } else {
                return left.get(key);
            } 
        } else if (this.key.compareTo(key) > 0) {
            if (right == null) {
                return null;
            } else {
                 return right.get(key);
            }
        } else {
            return value;
        }
    }

    public V remove(K key) {
        if (this.key.compareTo(key) < 0) {
            if (left == null) {
                return null;
            } else {
                return left.remove(key);
            } 
        } else if (this.key.compareTo(key) > 0) {
            if (right == null) {
                return null;
            } else {
                 return right.remove(key);
            }
        } else {
            V tempValue = value;
            value = getNextvalue();
            key = getNextKey();
            return tempValue;
        }
    }

    private V getNextvalue() {
        if (right == null) {
            return value;
        } else {
            return right.getMinValue();
        }
    }

    private V getMinValue() {
        if (left == null) {
            return value;
        } else {
            return left.getMinValue();
        }
    }

    private K getNextKey() {
        if (right == null) {
            return key;
        } else {
            return right.getMinKey();
        }
    }

    private K getMinKey() {
        if (left == null) {
            return key;
        } else {
            return left.getMinKey();
        }
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }
}
