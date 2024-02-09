package custom.list;

import java.util.List;

public class CustomList<T> {

    private List<T> list;

    public void add(T element) {
        list.add(element);
    }

    public boolean remove(T element) {
        return list.remove(element);
    }
}
