package generic.swap.string;

import java.util.Collections;
import java.util.List;

public class Box<T> {

    private T data;

    public Box(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return String.format("%s: %s", this.data.getClass().getName(), this.data);
    }

    public void swap(List<Box<String>> list, int firstIndex, int secondIndex) {
        Collections.swap(list, firstIndex, secondIndex);
    }
}
