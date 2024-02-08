package listy.iterator;

import java.util.Iterator;

public class ListyIterator implements Iterable<String>{

    private String[] stringList;

    public ListyIterator(String... stringList) {
        this.stringList = stringList;
    }

    @Override
    public Iterator<String> iterator() {
        return new ListIterator();
    }

    class ListIterator implements Iterator<String> {

        private int index = 0;
        @Override
        public boolean hasNext() {
            return index < stringList.length;
        }

        @Override
        public String next() {
            return stringList[index++];
        }
    }

}
