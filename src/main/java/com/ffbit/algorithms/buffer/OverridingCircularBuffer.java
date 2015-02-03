package com.ffbit.algorithms.buffer;

import java.util.NoSuchElementException;

/**
 * @see <a href="http://en.wikipedia.org/wiki/Circular_buffer">Circular buffer</a>
 */
public class OverridingCircularBuffer<E> {
    private final E[] elements;
    private final int capacity;
    private int start;
    private int end;
    private int size;

    @SuppressWarnings("unchecked")
    public OverridingCircularBuffer(int capacity) {
        this.capacity = capacity;
        elements = (E[]) new Object[capacity];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void write(E e) {
        if (size++ == capacity) {
            read();
        }

        end = end % capacity;
        elements[end++] = e;
    }

    public E read() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }

        start = start % capacity;
        E e = elements[start];
        elements[start++] = null;
        size--;

        return e;
    }

}
