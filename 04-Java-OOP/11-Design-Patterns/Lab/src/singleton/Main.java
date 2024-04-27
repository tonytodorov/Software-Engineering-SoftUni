package singleton;

public class Main {
    public static void main(String[] args) {
        Database database = Database.getInstance();

        database.create("Pesho", 42);
        database.create("Ivan", 29);

        Database database1 = Database.getInstance();
        int age = database.delete("Pesho");
        System.out.println(age);

    }
}


