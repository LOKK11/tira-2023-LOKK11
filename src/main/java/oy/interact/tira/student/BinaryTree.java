package oy.interact.tira.student;

import java.util.Comparator;
import java.util.function.Predicate;

import oy.interact.tira.util.Pair;
import oy.interact.tira.util.TIRAKeyedOrderedContainer;
import oy.interact.tira.util.Visitor;

public class BinaryTree<K extends Comparable<K>, V> implements TIRAKeyedOrderedContainer<K, V> {
    
    private Node<K,V> root = null;
    private int size = 0;
    private Comparator<K> comparator;
    private int capacity = Integer.MAX_VALUE;
    private Pair<K,V>[] array;
    private int addedToArray = 0;
    private int index;

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
            ++size;
        } else if (size < capacity) {
            if (addRecursion(node, root)) {
                ++size;
            }
        }
    }

    private boolean addRecursion(Node<K,V> newNode, Node<K,V> node) {
        if (newNode.getKey().compareTo(node.getKey()) < 0) {
            if (node.getLeft() == null) {
                node.addLeftChild();
                node.setLeft(newNode);
                return true;
            } else {
                if (addRecursion(newNode, node.getLeft())) {
                    node.addLeftChild();
                    return true;
                }
                return false;
            }
        } else if (newNode.getKey().compareTo(node.getKey()) > 0) {
            if (node.getRight() == null) {
                node.addRightChild();
                node.setRight(newNode);
                return true;
            } else {
                if (addRecursion(newNode, node.getRight())) {
                    node.addRightChild();
                    return true;
                }
                return false;
            }
        } else {
            node.setValue(node.getValue());
            return false;
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
            V tempValue = root.remove(root, key, null);
            if (tempValue != null) {
                --size;
            }
            return tempValue;
        } 
    }

    @Override 
    public V find(Predicate<V> searcher) {
        if (root == null) {
            return null;
        } else {
            return root.find(searcher);
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public int capacity() {
        return capacity;
    }

    @Override
    public void ensureCapacity(int capacity) throws OutOfMemoryError, IllegalArgumentException {
        if (capacity <= size()) {
            throw new IllegalArgumentException("Capacity cannot less than the amount of pairs currently on tree.");
        }
        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity cannot be less than 1");
        }
        this.capacity = capacity;
    }

    @Override
    public void clear() {
        root = null;
        size = 0;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Pair<K,V> [] toArray() throws Exception {
        if (root != null) {
            addedToArray = 0;
            array = new Pair[size];
            makeArray(root);
            return array;
        }
        return null;
    }

    private void makeArray(Node<K,V> node) {
        if (node.getLeft() != null) {
            makeArray(node.getLeft());
        }
        Pair<K,V> pair = new Pair<>(node.getKey(), node.getValue());
        addToArray(pair);
        if (node.getRight() != null) {
            makeArray(node.getRight());
        }
    }

    private void addToArray(Pair<K,V> pair) {
        array[++addedToArray - 1] = pair;
    }

    @Override
    public int findIndex(Predicate<V> searcher) {
        if (root == null) {
            return -1;
        }
        index = 0;
        return findIndexRecursion(searcher, root, -1);
    }

    private int findIndexRecursion(Predicate<V> searcher, Node<K,V> node, int value) {
        if (node.getLeft() != null) {
            value = findIndexRecursion(searcher, node.getLeft(), value);
            if (value != -1) {
                return value;
            }
        }

        if (searcher.test(node.getValue())) {
            return index;
        }
        ++index;

        if (node.getRight() != null) {
            value = findIndexRecursion(searcher, node.getRight(), value);
            if (value != -1) {
                return value;
            }
        }
        return value;
    }

    @Override
    public Pair<K,V> getIndex(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index value");
        }
        if (root == null) {
            return null;
        }
        return getIndexRecursion(root, index);
    }

    private Pair<K,V> getIndexRecursion(Node<K,V> node, int index) {
        if (node.getLeftChildren() > index) {
            return getIndexRecursion(node.getLeft(), index);
        } else if (node.getLeftChildren() < index) {
            index -= node.getLeftChildren() + 1;
            return getIndexRecursion(node.getRight(), index);
        } else {
            return new Pair<K,V>(node.getKey(), node.getValue());
        }
    }

    @Override
    public int indexOf(K itemKey) {
        if (root == null) {
            return -1;
        }
        index = root.getLeftChildren();
        return indexOfRecursion(itemKey, root, index);
    }

    private int indexOfRecursion(K itemKey, Node<K,V> node, int index) {
        if (itemKey.compareTo(node.getKey()) < 0) {
            index -= node.getLeft().getRightChildren() + 1;
            return indexOfRecursion(itemKey, node.getLeft(), index);
        } else if (itemKey.compareTo(node.getKey()) > 0) {
            index += node.getRight().getLeftChildren() + 1;
            return indexOfRecursion(itemKey, node.getRight(), index);          
        } else {
            return index;
        }
    }

    @Override
    public void accept(Visitor<K,V> visitor) throws Exception {

    }
}
