import java.util.function.Consumer;

public class CustomStack {

    private static final int INITIAL_CAPACITY = 4;

    private int[] items;
    private int size;
    private int capacity;

    public CustomStack() {
        this.items = new int[INITIAL_CAPACITY];
        this.capacity = INITIAL_CAPACITY;
    }

    public int getSize() {
        return this.size;
    }

    public void push(int element) {
        if (this.size == this.capacity) {
            this.resize();
        }

        this.items[this.size++] = element;
    }

    public int pop() {

        if (this.items.length > 0) {
            int lastItem = this.items[this.items.length - 1];
            int[] copyArr = new int[this.items.length];

            System.arraycopy(this.items, 0, copyArr, 0, this.items.length - 1);
            this.items = copyArr;

            return lastItem;
        }

        return -1;
    }

    public int peek() {
        return this.items[this.items.length - 1];
    }

    public void forEach(Consumer<Integer> consumer) {
        for (int item : this.items) {
            consumer.accept(item);
        }
    }

    public void resize() {
        this.capacity *= 2;
        int[] copy = new int[this.capacity];

        System.arraycopy(this.items, 0, copy, 0, this.items.length);

        this.items = copy;
    }


}
