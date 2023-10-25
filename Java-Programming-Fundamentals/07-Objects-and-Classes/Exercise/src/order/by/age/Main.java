package order.by.age;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();

        List<People> peopleList = new ArrayList<>();

        while (!command.equals("End")) {

            String[] tokens = command.split(" ");

            String name = tokens[0];
            String id = tokens[1];
            int age = Integer.parseInt(tokens[2]);

            People people = new People(name, id, age);
            peopleList.add(people);

            command = scanner.nextLine();
        }

        List<Integer> ages = ages(peopleList);
        printList(peopleList, ages);

    }

    public static List<Integer> ages(List<People> peopleList) {

        List<Integer> ages = new ArrayList<>();

        for (People people : peopleList) {
            ages.add(people.getAge());
        }

        Collections.sort(ages);

        return ages;
    }

    public static void printList(List<People> peopleList, List<Integer> ages) {

        for (Integer age : ages) {
            for (People people: peopleList) {
                if (age == people.getAge()) {
                    System.out.printf("%s with ID: %s is %d years old.%n",
                            people.getName(),
                            people.getId(),
                            people.getAge());
                }
            }
        }
    }
}
