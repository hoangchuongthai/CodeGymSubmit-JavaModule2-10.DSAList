package src;

import java.util.Arrays;

public class MyList<E> {

    // Current number of elements
    private int size = 0;

    // Default capacity
    private static final int DEFAULT_CAPACITY = 10;

    // Internal array to store data
    private Object[] elements;

    // Default constructor
    public MyList() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    // Constructor with custom capacity
    public MyList(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity must be greater than 0");
        }
        elements = new Object[capacity];
    }

    // Ensure minimum capacity
    public void ensureCapacity(int minCapacity) {
        if (minCapacity > elements.length) {
            int newCapacity = Math.max(minCapacity, elements.length * 2);
            elements = Arrays.copyOf(elements, newCapacity);
        }
    }

    // Add element to the end
    public boolean add(E e) {
        ensureCapacity(size + 1);
        elements[size++] = e;
        return true;
    }

    // Add element at specific index
    public void add(int index, E element) {
        checkIndexForAdd(index);
        ensureCapacity(size + 1);

        System.arraycopy(elements, index, elements, index + 1, size - index);
        elements[index] = element;
        size++;
    }

    // Remove element at index
    public E remove(int index) {
        checkIndex(index);

        E removed = get(index);
        int moveCount = size - index - 1;

        if (moveCount > 0) {
            System.arraycopy(elements, index + 1, elements, index, moveCount);
        }

        elements[--size] = null; // Avoid memory leak
        return removed;
    }

    // Get current size
    public int size() {
        return size;
    }

    // Check if list contains element
    public boolean contains(E o) {
        return indexOf(o) >= 0;
    }

    // Get index of element
    public int indexOf(E o) {
        for (int i = 0; i < size; i++) {
            if (o == null ? elements[i] == null : o.equals(elements[i])) {
                return i;
            }
        }
        return -1;
    }

    // Get element at index
    public E get(int index) {
        checkIndex(index);
        return elementAt(index);
    }

    // Clear all elements
    public void clear() {
        Arrays.fill(elements, 0, size, null);
        size = 0;
    }

    // Clone current MyList
    @SuppressWarnings("unchecked")
    public MyList<E> clone() {
        MyList<E> newList = new MyList<>(size);
        newList.size = this.size;
        newList.elements = Arrays.copyOf(this.elements, size);
        return newList;
    }

    // Get element from internal array
    @SuppressWarnings("unchecked")
    private E elementAt(int index) {
        return (E) elements[index];
    }

    // Check valid index for get, remove
    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }

    // Check valid index for add
    private void checkIndexForAdd(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }
}
