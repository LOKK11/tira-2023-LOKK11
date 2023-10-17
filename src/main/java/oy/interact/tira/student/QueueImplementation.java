package oy.interact.tira.student;

import oy.interact.tira.util.QueueInterface;

public class QueueImplementation<E> implements QueueInterface<E> {
    
    static final int DEFAULT_STACK_SIZE = 20;
    Object[] queue;
    int head = 0;
    int tail = 0;

    @Override
    public int capacity() {
        return queue.length;
    }

    public QueueImplementation() {
        queue = new Object[DEFAULT_STACK_SIZE];
    }

    public QueueImplementation(int capacity) {
        queue = new Object[capacity];
    }

    @Override
    public void enqueue(E element) throws OutOfMemoryError, NullPointerException {
        if (element == null) {
            throw new NullPointerException("Added element cannot be null");
        }
        if (size() == capacity()) {
            try {
                reallocate();
            } catch (OutOfMemoryError e) {
                throw new QueueAllocationException("Ran out of memory during reallocation");
            }
        }
        queue[tail] = element;
        ++tail;
        tail = changeIfOverCapacity(tail);
    }

    private int changeIfOverCapacity(int pointer) {
        if (pointer == capacity()) {
            return 0;
        }
        return pointer;
    }

    private void reallocate() {
        Object[] temp = new Object[capacity() * 2];
        for (int i = head; i < capacity(); i++) {
            temp[capacity() + i] = queue[i];
        }
        head += capacity();
        for (int j = 0; j < tail; j++) {
            temp[j] = queue[j];
        }
        queue = temp;
    }

    @SuppressWarnings("unchecked")
    @Override
    public E dequeue() throws IllegalStateException {
        if (isEmpty()) {
            throw new QueueIsEmptyException("Cannot dequeue from an empty queue");
        }
        E temp = (E) queue[head];
        queue[head] = null;
        ++head;
        head = changeIfOverCapacity(head);
        return temp;
    }

    @SuppressWarnings("unchecked")
    @Override
    public E element() throws IllegalStateException {
        if (isEmpty()) {
            throw new QueueIsEmptyException("Cannot dequeue from an empty queue");
        }
        return (E) queue[head];        
    }

    @Override
    public int size() {
        if (tail < head) {
            return tail - head + capacity();
        } else if (head == tail && !isEmpty()) {
            return capacity();
        }
        return tail - head;
    }

    @Override
    public boolean isEmpty() {
        if (queue[head] == null) {
            return true;
        }
        return false;
    }

    public void clear() {
        Object[] temp = new Object[DEFAULT_STACK_SIZE];
        tail = 0;
        head = 0;
        queue = temp;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder("[");
        if (!isEmpty()) {
            str.append(queue[head]);
            boolean cleared = false;
            for (int i = head + 1; i < capacity(); i++) {
                if (queue[i] == null) {
                    cleared = true;
                    break;
                }
                str.append(", ");
                str.append(queue[i]);
            }
            for (int i = 0; i < tail && !cleared; i++) {
                if (queue[i] == null) {
                    break;
                }    
                str.append(", ");
                str.append(queue[i]);           
            }
        }
        str.append("]");
        return str.toString();
    }
}
