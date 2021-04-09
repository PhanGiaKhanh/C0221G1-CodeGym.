package bai10_dsa_list.bai_tap.implementing_method_arraylist;

import java.util.Arrays;

public class MyList<E> {
    private int size;
    private static final int DEFAULT_CAPACITY = 10;
    private Object elements[];

    public MyList() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    public MyList(int capacity) {
        elements = Arrays.copyOf(elements, capacity);
    }

    void add(int index, E element) {
        E temp1, temp2 = element;
        if (size == elements.length) {
            ensureCapacity(10);
        }
        size += 1;
        for (int i = index - 1; i < size; i++) {
            temp1 = (E) elements[i];

            elements[i] = temp2;
            temp2 = temp1;
        }

    }

    public E remove(int index) {
        E temp;
        for (int i = index-1; i < size - 1; i++) {
            elements[i] = elements[i + 1];
        }
        size -= 1;
        return (E) elements;
    }

    public int size() {
        return size;
    }

    public E clone() {
        return (E) elements;
    }

    public boolean contains(E o) {
        for (int i = 0; i < elements.length; i++) {
            if (elements[i] == o) {
                return true;
            }
        }
        return false;
    }

    public int indexOf(E o) {
        for (int i = 0; i < elements.length; i++) {
            if (elements[i] == o) {
                return i;
            }
        }
        return -1;
    }

    public boolean add(E e) {
        if (size == elements.length) {
            ensureCapacity(10);
        }
        elements[size++] = e;
        return true;
    }

    public void ensureCapacity(int minCapacity) {
        int newSize = elements.length + minCapacity;
        elements = Arrays.copyOf(elements, newSize);
    }

    public E get(int i) {
        if (i >= size || i < 0) {
            throw new IndexOutOfBoundsException("Index: " + i + ", Size " + i);
        }
        return (E) elements[i];
    }

    public void clear() {
        size = 0;
    }
    public int length(){
        return elements.length;
    }
}
