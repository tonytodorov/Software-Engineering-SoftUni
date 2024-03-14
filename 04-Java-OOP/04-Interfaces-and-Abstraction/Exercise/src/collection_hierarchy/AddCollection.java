package collection_hierarchy;

public class AddCollection extends Collection implements Addable {

    @Override
    public int add(String item) {
        super.getItems().add(item);
        return getItems().indexOf(item);
    }
}
