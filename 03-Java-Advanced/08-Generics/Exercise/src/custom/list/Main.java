package custom.list;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();

        CustomList<String> list = new CustomList<>();


        while (!"END".equals(command)) {
            String[] tokens = command.split("\\s+");
            String operation = tokens[0];

            if ("Add".equals(operation)) {
                String element = tokens[1];
                list.add(element);
            } else if ("Remove".equals(operation)) {
                int index = Integer.parseInt(tokens[1]);
                list.remove(index);
            } else if ("Contains".equals(operation)) {
                String element = tokens[1];
                System.out.println(list.contains(element));
            } else if ("Swap".equals(operation)) {
                int firstElementIndex = Integer.parseInt(tokens[1]);
                int secondElementIndex = Integer.parseInt(tokens[2]);
                list.swap(firstElementIndex, secondElementIndex);
            } else if ("Greater".equals(operation)) {
                String element = tokens[1];
                int countGreaterThan = list.countGreaterThan(element);
                System.out.println(countGreaterThan);
            } else if ("Max".equals(operation)) {
                String max = list.getMax();
                System.out.println(max);
            } else if ("Min".equals(operation)) {
                String min = list.getMin();
                System.out.println(min);
            } else if ("Sort".equals(operation)) {
                Sorter.sort(list);
            } else if ("Print".equals(operation)) {
                list.print();
            }

            command = scanner.nextLine();
        }
    }
}
