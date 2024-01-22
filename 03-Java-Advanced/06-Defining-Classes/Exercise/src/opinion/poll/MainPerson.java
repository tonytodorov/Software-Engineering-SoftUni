package opinion.poll;

import java.util.*;

public class MainPerson {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String, Integer> persons = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            String[] data = scanner.nextLine().split("\\s+");
            Person person = new Person(data[0], Integer.parseInt(data[1]));

            if (person.getAge() > 30) {
                persons.putIfAbsent(person.getName(), person.getAge());
            }
        }

        for (Map.Entry<String, Integer> entry: persons.entrySet()) {
            System.out.printf("%s - %d%n", entry.getKey(), entry.getValue());
        }
    }
}
