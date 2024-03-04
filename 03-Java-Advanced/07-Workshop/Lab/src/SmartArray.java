import java.util.function.Consumer;

public class SmartArray {

    private static final int INITIAL_CAPACITY = 4;

    private int[] data;
    private int size;
    private int capacity;

    public SmartArray() {
        this.data = new int[INITIAL_CAPACITY];
        this.capacity = INITIAL_CAPACITY;
    }

    public void add(int element) {
        if (this.size == this.capacity) {
            this.resize();
        }

        this.data[this.size++] = element;
    }

    public void resize() {
        this.capacity *= 2;
        int[] copy = new int[this.capacity];

        System.arraycopy(this.data, 0, copy, 0, this.data.length);

        this.data = copy;
    }

    public int get(int index) {
        if (!isValidIndex(index)) {
            throw new IndexOutOfBoundsException();
        }

        return this.data[index];
    }

    public int remove(int index) {
        if (!isValidIndex(index)) {
            throw new IndexOutOfBoundsException();
        }

        int[] copyArr = new int[data.length - 1];
        int currentIndex = 0;

        for (int i = 0; i < data.length; i++) {
            if (data[i] != data[index]) {
                copyArr[currentIndex] = data[i];
                currentIndex++;
            }
        }

        this.data = copyArr;

        return this.data[index];
    }

    public boolean contains(int element) {
        for (int currentNum : data) {
            if (currentNum == element) {
                return true;
            }
        }

        return false;
    }

    public void add(int firstIndex, int secondIndex) {
        
    }

    public void forEach(Consumer<Integer> consumer) {
        for (int element : this.data) {
            consumer.accept(element);
        }
    }

    private boolean isValidIndex(int index) {
        return index >= 0 && index <= this.data.length;
    }
}
