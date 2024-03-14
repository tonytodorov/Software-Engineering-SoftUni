package collection_hierarchy;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> input = Arrays.stream(scanner.nextLine().split("\\s+")).collect(Collectors.toList());

        Addable addCollection = new AddCollection();
        AddRemovable addRemoveCollection = new AddRemoveCollection();
        MyList myList = new MyListImpl();

        for (String text: input) {
            System.out.print(addCollection.add(text) + " ");
        }

        System.out.println();

        for (String text: input) {
            System.out.print(addRemoveCollection.add(text) + " ");
        }

        System.out.println();

        for (String text: input) {
            System.out.print(myList.add(text) + " ");
        }

        System.out.println();

        int removeTimes = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < removeTimes; i++) {
            System.out.print(addRemoveCollection.remove() + " ");
        }

        System.out.println();

        for (int i = 0; i < removeTimes; i++) {
            System.out.print(myList.remove() + " ");
        }

    }
}
