package oy.interact.tira.student;

import java.util.function.Predicate;

public class Node<K extends Comparable<K>, V> {
    private K key;
    private V value;
    private Node<K,V> left;
    private Node<K,V> right;
    
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
        if (searcher.test(value)) {
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

    public V remove(Node<K,V> node, K key) {
        if (this.key.compareTo(key) < 0) {
            if (left == null) {
                return null;
            } else {
                return left.remove(left, key);
            } 
        } else if (this.key.compareTo(key) > 0) {
            if (right == null) {
                return null;
            } else {
                 return right.remove(right, key);
            }
        } else {
            V tempValue = value;
            if (left == null && right == null) {
                node = null;
            } else if (left != null && right != null) {
                Node<K,V> min = getMin(right);
                this.value = min.getValue();
                this.key = min.getKey();
                right.remove(right, this.key);
            } else if (right != null) {
                node = right;
            } else {
                node = left;
            }
            return tempValue;
        }
    }

    private Node<K,V> getMin(Node<K,V> node) {
        if (left == null) {
            return node;
        } else {
            return left.getMin(left);
        }
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    public Node<K,V> getRight() {
        return right;
    }

    public Node<K,V> getLeft() {
        return left;
    }
}
