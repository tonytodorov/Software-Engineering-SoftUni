package representation;

public class ArrayStorage {
    private final int INITIAL_CAPACITY = 4;

    private int[] elements;
    private int index;

    public ArrayStorage() {
        this.elements = new int[INITIAL_CAPACITY];
        this.index = 0;
    }

    public boolean add(int element) {
        add(element, index++);
        return true;
    }

    public boolean remove(int element) {
        removeElement(element);
        return true;
    }

    public boolean contains(int element) {
        return containsElement(element);
    }

    private void add(int element, int index) {
        if (index == this.elements.length) {
            elements = grow(elements);
        }

        this.elements[index] = element;
    }

    private void removeElement(int element) {
        int[] tempArr = new int[elements.length - 1];
        int splitIndex = 0;

        for (int i = 0; i < elements.length; i++) {
            if (elements[i] == element) {
                splitIndex = i;
                break;
            }
        }

        int startIndex = 0;

        for (int i = 0; i < elements.length; i++) {
            if (splitIndex != i) {
                tempArr[startIndex] = elements[i];
                startIndex++;
            }
        }

        elements = tempArr;
    }

    private boolean containsElement(int element) {
        for (int currentElement : elements) {
            if (currentElement == element) {
                return true;
            }
        }

        return false;
    }

    private int[] grow(int[] elements) {
        int[] resizeArr = new int[elements.length + 1];

        System.arraycopy(elements, 0, resizeArr, 0, elements.length);
        return resizeArr;
    }

    // TODO: Implement additional operations like: remove(int element), contains(int element) and more
}
