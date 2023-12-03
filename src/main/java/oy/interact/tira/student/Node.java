package oy.interact.tira.student;

import java.util.Comparator;
import java.util.function.Predicate;


public class Node<K extends Comparable<K>, V> {
    private K key;
    private V value;
    private Node<K,V> parent;
    private Node<K,V> left;
    private Node<K,V> right;
    private Node<K,V> nextLinkedNode;
    private Node<K,V> previousLinkedNode;
    private int leftChildren;
    private int rightChildren;
    
    
    public Node(K key, V value) {
        this.key = key;
        this.value = value;
        left = null;
        right = null;
        nextLinkedNode = null;
        previousLinkedNode = null;
        leftChildren = 0;
        rightChildren = 0;
    }

    public V get(K key, Comparator<K> comparator) {
        if (comparator.compare(key, this.key) < 0) {
            if (left == null) {
                return null;
            } else {
                return left.get(key, comparator);
            } 
        } else if (comparator.compare(key, this.key) > 0) {
            if (right == null) {
                return null;
            } else {
                 return right.get(key, comparator);
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

    public V remove(Node<K,V> node, K key, V value, Comparator<K> comparator) {
        if (comparator.compare(key, this.key) < 0) {
            if (left == null) {
                return null;
            } else {
                value = left.remove(left, key, value, comparator);
                if (value != null) {
                    --leftChildren;
                }
                return value;
            } 
        } else if (comparator.compare(key, this.key) > 0) {
            if (right == null) {
                return null;
            } else {
                value = right.remove(right, key, value, comparator);
                if (value != null) {
                    --rightChildren;
                }
                return value;
            }
        } else {
            V tempValue = this.value;
            if (left == null && right == null) {
                if (node.getParent().getRight() == node) {
                    node.getParent().setRight(null);
                } else {
                    node.getParent().setLeft(null);
                }
            } else if (left != null && right != null) {
                Node<K,V> min = getMin(right);
                this.value = min.getValue();
                this.key = min.getKey();
                this.nextLinkedNode = min.getNextLinkedNode();
                --rightChildren;
                right.remove(right, this.key, value, comparator);
            } else if (right != null) {
                if (node.getParent().getRight() == node) {
                    node.getParent().setRight(right);
                } else {
                    node.getParent().setLeft(right);
                }
            } else {
                if (node.getParent().getRight() == node) {
                    node.getParent().setRight(left);
                } else {
                    node.getParent().setLeft(left);
                }
            }
            return tempValue;
        }
    }

    private Node<K,V> getMin(Node<K,V> node) {
        if (node.getLeft() == null) {
            return node;
        } else {
            return getMin(node.getLeft());
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

    public void setParent(Node<K,V> node) {
        parent = node;
    }

    public Node<K,V> getParent() {
        return parent;
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

    public void setKey(K key) {
        this.key = key;
    }

    public void setNextLinkedNode(Node<K,V> node) {
        nextLinkedNode = node;
    }

    public void setPreviousLinkedNode(Node<K,V> node) {
        previousLinkedNode = node;
    }

    public Node<K,V> getNextLinkedNode() {
        return nextLinkedNode;
    }

    public Node<K,V> getPreviousLinkedNode() {
        return previousLinkedNode;
    }
}
