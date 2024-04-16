package implementations;

import interfaces.List;

import java.util.Arrays;
import java.util.Iterator;

public class ArrayList<E> implements List<E> {

    public static final int INITIAL_SIZE = 4;
    private Object[] elements;
    private int size;
    private int capacity;

    public ArrayList() {
        this.elements = new Object[INITIAL_SIZE];
        this.size = 0;
        this.capacity = elements.length;
    }

    @Override
    public boolean add(E element) {
        if (this.size >= this.capacity) {
            grow();
        }

        this.elements[size++] = element;
        return true;
    }

    private void grow() {
        Object[] copyArr = new Object[elements.length + 1];

        System.arraycopy(elements, 0, copyArr, 0, elements.length);

        elements = copyArr;
    }

    @Override
    public boolean add(int index, E element) {
        if (checkIndex(index)) {
            insert(index, element);
        }

        return true;
    }

    private void insert(int index, E element) {
        Object[] copyArr = new Object[elements.length + 1];

        for (int i = 0; i < index; i++) {
            copyArr[i] = elements[i];
        }

        copyArr[index] = element;

        for (int i = index; i < elements.length; i++) {
            copyArr[i + 1] = elements[i];
        }

        elements = copyArr;
    }

    private boolean checkIndex(int index) {
        return index >= 0 && index <= elements.length - 1;
    }

    @Override
    public E get(int index) {
        if (!checkIndex(index)) {
            throw new IndexOutOfBoundsException("Invalid index!");
        }

        Object element = elements[index];
        return (E) element;
    }

    @Override
    public E set(int index, E element) {
        if (!checkIndex(index)) {
            throw new IndexOutOfBoundsException("Invalid index!");
        }

        Object prevElement = this.elements[index];
        this.elements[index] = element;
        return (E) prevElement;
    }

    @Override
    public E remove(int index) {
        if (!checkIndex(index) || size == 0) {
            throw new IndexOutOfBoundsException("Invalid index!");
        }

        Object element = elements[index];
        int startIndex = 0;

        Object[] copyArr = new Object[elements.length - 1];

        for (int i = 0; i < elements.length; i++) {
            if (i != index) {
                copyArr[startIndex++] = elements[i];
            }
        }

        return (E) element;
    }

    @Override
    public int size() {
        return elements.length;
    }

    @Override
    public int indexOf(E element) {
        return 0;
    }

    @Override
    public boolean contains(E element) {
        for (Object e : elements) {
            if (e == element) {
                return true;
            }
        }

        return false;
    }

    @Override
    public boolean isEmpty() {
        return elements.length > 0;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private int index = 0;
            @Override
            public boolean hasNext() {
                return this.index < elements.length;
            }

            @Override
            public E next() {
                return get(index++);
            }
        };
    }
}
