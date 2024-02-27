package random_arraylist;

import java.util.ArrayList;
import java.util.List;

public class RandomArrayList extends ArrayList<Object> {

    private List<Object> objectList;

    public RandomArrayList() {
        this.objectList = new ArrayList<>();
    }

    public void getRandomElement(Object obj) {
        System.out.println(remove(obj));
    }

}
