package oy.interact.tira.student;

import java.util.function.Predicate;

public class Node<K extends Comparable<K>, V> {
    private K key;
    private V value;
    private Node<K,V> left;
    private Node<K,V> right;
    private int leftChildren;
    private int rightChildren;
    
    public Node(K key, V value) {
        this.key = key;
        this.value = value;
        left = null;
        right = null;
        leftChildren = 0;
        rightChildren = 0;
    }

    public V get(K key) {
        if (key.compareTo(this.key) < 0) {
            if (left == null) {
                return null;
            } else {
                return left.get(key);
            } 
        } else if (key.compareTo(this.key) > 0) {
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
            return value;
        }
        if (left != null) {
            V tempValue = left.find(searcher);
            if (tempValue != null) {
                return tempValue;
            }
        }
        if (right != null) {
            V tempValue = right.find(searcher);
            if (tempValue != null) {
                return tempValue;
            }
        } 
        return null;
    }

    public V remove(Node<K,V> node, K key, V value) {
        if (this.key.compareTo(key) < 0) {
            if (left == null) {
                return null;
            } else {
                value = left.remove(left, key, value);
                if (value != null) {
                    --leftChildren;
                }
                return value;
            } 
        } else if (this.key.compareTo(key) > 0) {
            if (right == null) {
                return null;
            } else {
                value = right.remove(right, key, value);
                if (value != null) {
                    --rightChildren;
                }
                return value;
            }
        } else {
            V tempValue = this.value;
            if (left == null && right == null) {
                node = null;
            } else if (left != null && right != null) {
                Node<K,V> min = getMin(right);
                this.value = min.getValue();
                this.key = min.getKey();
                --rightChildren;
                right.remove(right, this.key, value);
            } else if (right != null) {
                --rightChildren;
                node = right;
            } else {
                --leftChildren;
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

    public int getLeftChildren() {
        return leftChildren;
    }

    public int getRightChildren() {
        return rightChildren;
    }

    public void addLeftChild() {
        ++leftChildren;
    }

    public void setLeft(Node<K,V> node) {
        this.left = node;
    }

    public void addRightChild() {
        ++rightChildren;
    }

    public void setRight(Node<K,V> node) {
        this.right = node;
    }

    public void setValue(V value) {
        this.value = value;
    }
}
