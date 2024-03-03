public class SmartArray {

    private int[] data;
    private int size;
    private int capacity;

    public SmartArray() {
        this.data = new int[5];
        this.capacity = 5;
    }

    public void add(int element) {
        if (this.size == this.capacity) {
            this.resize();
        }

        this.data[this.size++] = element;
    }

    public void resize() {
        this.capacity += 1;
        int[] copy = new int[this.capacity];

        System.arraycopy(this.data, 0, copy, 0, this.data.length);

        this.data = copy;
    }

    public void get(int index) {
        
    }
}
