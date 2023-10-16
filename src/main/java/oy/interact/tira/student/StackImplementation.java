package oy.interact.tira.student;

import oy.interact.tira.util.StackInterface;

public class StackImplementation<E> implements StackInterface<E> {

    private Object [] itemArray;
    private int capacity;
    private static final int DEFAULT_STACK_SIZE = 10;
    private int count = 0;

    public StackImplementation() {
        capacity = DEFAULT_STACK_SIZE;
        itemArray = new Object[capacity];
    }

    public StackImplementation(int size) {
        capacity = size;
        itemArray = new Object[capacity];
    }

    @Override
    public int capacity() {
        return capacity;
    }

    @Override
    public void push(E element) throws OutOfMemoryError, NullPointerException {
        if (element == null) {
            throw new NullPointerException("Element cannot be null");
        }
        try {
            if (count >= capacity) {
                reallocate();
            }
            itemArray[count] = element;
            count++;          
        } catch (OutOfMemoryError e) {  
            throw new OutOfMemoryError("System ran out of memory");
        }

    }

    private void reallocate() {
        capacity *= 2;
        Object[] tempArray = new Object[capacity];
        for (int i = 0; i < count; i++) {
            tempArray[i] = itemArray[i];
        }
        itemArray = tempArray;
    }

    @SuppressWarnings("unchecked")
    @Override
    public E pop() throws IllegalStateException {
        if (isEmpty()) {
            throw new IllegalStateException("The stack is empty");
        }
        E temp = (E)itemArray[count - 1];
        itemArray[count - 1] = null;
        count--;
        return temp;
    }

    @SuppressWarnings("unchecked")
    @Override
    public E peek() throws IllegalStateException {
        if (isEmpty()) {
            throw new IllegalStateException("The stack is empty");
        }
        return (E)itemArray[count - 1];   
    }

    @Override
    public int size() {
        return count;
    }

    @Override
    public boolean isEmpty() {
        return count == 0;
    }

    @Override
    public void clear() {
        Object[] tempArray = new Object[DEFAULT_STACK_SIZE];
        capacity = DEFAULT_STACK_SIZE;
        itemArray = tempArray;
        count = 0;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder("[");
        if (!isEmpty()) {
            str.append(itemArray[0]);
        }
        for (int i = 1; i < count; i++) {
            str.append(", ");
            str.append(itemArray[i]);
        }
        str.append("]");
        return str.toString();
    }
}
