package generic.scale;

public class Scale<T extends Comparable<T>> {

    private T left;
    private T right;

    public Scale(T left, T right) {
        this.left = left;
        this.right = right;
    }

    public T getHeavier() {
        int compare = this.left.compareTo(right);

        if (compare == 0) {
            return null;
        } else if (compare < 0) {
            return right;
        }

        return left;
    }
}
