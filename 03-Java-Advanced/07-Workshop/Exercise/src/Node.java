public class Node {

    private int item;
    private Node next;
    private Node previous;

    public Node(int item) {
        this.item = item;
    }

    public int getItem() {
        return item;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node getPrevious() {
        return previous;
    }

    public void setPrevious(Node previous) {
        this.previous = previous;
    }
}
