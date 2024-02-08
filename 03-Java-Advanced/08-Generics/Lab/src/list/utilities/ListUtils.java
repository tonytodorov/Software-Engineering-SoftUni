package list.utilities;

import java.util.List;

public class ListUtils<T> {

    public static <T extends Comparable<T>> T getMin(List<T> list) {
        emptyList(list);
        return list.stream().min(Comparable::compareTo).get();
    }

    public static <T extends Comparable<T>> T getMax(List<T> list) {
        emptyList(list);
        return list.stream().max(Comparable::compareTo).get();
    }

    public static <T> void emptyList(List<T> list) {
        if (list.isEmpty()) {
            throw new IllegalArgumentException();
        }
    }
}
