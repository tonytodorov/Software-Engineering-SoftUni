import java.util.function.Consumer;

public class ArrayDeque {

    private ArrayDeque arrayDeque;

    public ArrayDeque() {
        this.arrayDeque = new ArrayDeque();
    }

    public void push(int element) {
        arrayDeque.push(element);
    }

    public int pop() {
        return arrayDeque.pop();
    }

    public int peek() {
        return arrayDeque.peek();
    }

    public void forEach(Consumer<Integer> consumer) {
        for (int i = 0; i < arrayDeque.s; i++) {

        }
    }
}
