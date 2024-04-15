package representation;

public class Main {

    public static void main(String[] args) {
        ArrayStorage arrayStorage = new ArrayStorage();

        arrayStorage.add(4);
        arrayStorage.add(5);
        arrayStorage.add(6);
        arrayStorage.add(7);
        arrayStorage.add(8);
        arrayStorage.add(9);
        arrayStorage.add(10);

        arrayStorage.remove(4);
        System.out.println(arrayStorage.contains(7));
    }
}
