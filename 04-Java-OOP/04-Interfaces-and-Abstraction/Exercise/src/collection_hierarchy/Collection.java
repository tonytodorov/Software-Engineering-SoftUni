package collection_hierarchy;

import java.util.ArrayList;
import java.util.List;

public abstract class Collection {

    private static final int MAX_SIZE = 100;
    private List<String> items;

    public Collection() {
        this.items = new ArrayList<>(MAX_SIZE);
    }

    public List<String> getItems() {
        return items;
    }


}
