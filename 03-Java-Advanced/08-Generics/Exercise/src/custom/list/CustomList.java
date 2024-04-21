package custom.list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class CustomList<T extends Comparable<T>> implements Iterable<T> {

    private List<T> elements;

    public CustomList() {
        this.elements = new ArrayList<>();
    }

    public void add(T element) {
        elements.add(element);
    }

    public T remove(int index) {
       return elements.remove(index);
    }

    public boolean contains(T element) {
        return elements.contains(element);
    }

    public void swap(int firstElementIndex, int secondElementIndex) {
        Collections.swap(elements, firstElementIndex, secondElementIndex);
    }

    public int countGreaterThan(T element) {
        return (int) elements.stream()
                .filter(e -> e.compareTo(element) > 0)
                .count();
    }

    public T getMax() {
        return elements.stream()
                .max(Comparable::compareTo)
                .get();
    }

    public T getMin() {
        return elements.stream()
                .min(Comparable::compareTo)
                .get();
    }

    public void print() {
        for (T element : elements) {
            System.out.println(element);
        }
    }

    public int size() {
        return elements.size();
    }


    public T get(int index) {
        return elements.get(index);
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int index = 0;
            @Override
            public boolean hasNext() {
                return index < elements.size();
            }

            @Override
            public T next() {
                return elements.get(index++);
            }
        };
    }
}
