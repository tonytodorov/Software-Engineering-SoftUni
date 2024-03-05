import java.util.NoSuchElementException;
import java.util.function.Consumer;

public class DoublyLinkedList {

    private Node head;
    private Node tail;
    private int size;

    public void addFirst(int element) {

        Node newHead = new Node(element);

        if (this.size == 0) {
            this.head = this.tail = newHead;
        } else {
            newHead.setNext(this.head);
            this.head.setPrevious(newHead);
            this.head = newHead;
        }

        this.size++;
    }

    public void addLast(int element) {

        Node newTail = new Node(element);

        if (this.size == 0) {
            this.head = this.tail = newTail;
        } else {
            newTail.setNext(this.tail);
            this.tail.setPrevious(newTail);
            this.tail = newTail;
        }

        this.size++;
    }

    public int get(int index) {
        checkIndex(index);

        if (index <= this.size / 2) {
            Node firstNode = this.head;

            for (int i = 0; i < index; i++) {
                firstNode = firstNode.getNext();
            }

            return firstNode.getItem();
        } else {
            Node lastNode = this.tail;

            for (int i = this.size - 1; i > index; i--) {
                lastNode = lastNode.getPrevious();
            }

            return lastNode.getItem();
        }
    }

    public int removeFirst() {
        checkSize();

        if (this.size == 1) {
            this.head = this.tail = null;
        } else {
            this.tail.setNext(null);
        }

        this.size--;
        return this.tail.getItem();
    }

    public void forEach(Consumer<Integer> consumer) {
        Node currentNode = this.head;

        while (currentNode != null) {
            consumer.accept(currentNode.getItem());
            currentNode = currentNode.getNext();
        }
    }

    public int[] toArray() {
        int[] arr = new int[this.size];

        Node currentNode = this.head;

        for (int i = 0; i < arr.length; i++) {
            arr[i] = currentNode.getItem();
            currentNode = currentNode.getNext();
        }

        return arr;
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= this.size) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
    }

    private void checkSize() {
        if (this.size == 0) {
            throw new NoSuchElementException("Empty list");
        }
    }
}
