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
        this.capacity = this.capacity * 2;
        copyArr();
    }

    public void shrink() {
        this.capacity = this.capacity / 2;
        copyArr();
    }

    private void copyArr() {
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

    public void shiftLeft(int index) {

        int[] copyArr = new int[this.data.length - 1];
        int startIndex = 0;

        for (int i = 0; i < this.data.length; i++) {
            if (index != i) {
                copyArr[startIndex] = this.data[i];
                startIndex++;
            }
        }

        this.data = copyArr;
    }

    public void shiftRight(int index) {
        int[] copyLeftPart = new int[index];
        int[] copyRightPart = new int[data.length - index];

        for (int i = 0; i < copyLeftPart.length; i++) {
            copyLeftPart[i] = data[i];
        }

        for (int i = 0; i < copyRightPart.length; i++) {
            copyRightPart[i] = data[index + i];
        }

        int[] result = new int[data.length + 1];


        System.arraycopy(copyLeftPart, 0, result, 0, result.length);
        System.arraycopy(copyRightPart, 0, result, 0, result.length);

        this.data = result;
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
