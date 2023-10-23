import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class _03_OpinionPoll {

    public static class Person {

        String name;
        int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        List<Person> personList = new ArrayList<>();

        for (int i = 0; i < n; i++) {

            String[] tokens = scanner.nextLine().split(" ");

            String name = tokens[0];
            int age = Integer.parseInt(tokens[1]);

            Person person = new Person(name, age);
            personList.add(person);
        }

        for (Person person: personList) {
            if (person.getAge() > 30) {
                System.out.printf("%s - %d%n", person.getName(), person.getAge());
            }
        }

    }
}
