package generic.count.doubles;

import java.util.List;

public class Box<T extends Comparable<T>> implements Comparable<Box<T>>{

    private T data;

    public Box(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return String.format("%s: %s", this.data.getClass().getName(), this.data);
    }

    @Override
    public int compareTo(Box<T> o) {
        return this.data.compareTo(o.data);
    }

    public static <T extends Comparable<T>> int count(List<T> list, T element) {

        int count = 0;

        for (T t : list) {
            int result = t.compareTo(element);
            if (result > 0) {
                count++;
            }
        }

        return count;
    }
}
