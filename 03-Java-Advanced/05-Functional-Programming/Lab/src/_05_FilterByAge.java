import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class _05_FilterByAge {

    public static class People {
        String name;
        int age;

        public People(String name, int age) {
            this.name = name;
            this.age = age;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        List<People> persons = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] data = scanner.nextLine().split(",\\s+");

            String name = data[0];
            int age = Integer.parseInt(data[1]);

            People people = new People(name, age);
            persons.add(people);
        }

        String condition = scanner.nextLine();
        int age = Integer.parseInt(scanner.nextLine());
        String format = scanner.nextLine();

        Predicate<People> youngerOrOlder = createFilter(condition, age);
        Consumer<People> print = createPrint(format);

        persons.stream()
                .filter(youngerOrOlder)
                .forEach(print);
        
    }

    private static Predicate<People> createFilter(String condition, int age) {
        if ("younger".equals(condition)) {
            return people -> people.age < age;
        }

        return people -> people.age >= age;
    }


    private static Consumer<People> createPrint(String format) {
        if (format.equals("name")) {
            return people -> System.out.println(people.name);
        } else if (format.equals("age")) {
            return people -> System.out.println(people.age);
        } else {
            return people -> System.out.println(people.name + " - " + people.age);
        }
    }
}
