import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _03_Inventory {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> items = Arrays.stream(scanner.nextLine()
                        .split(", "))
                .collect(Collectors.toList());

        String command = scanner.nextLine();

        while (!command.equals("Craft!")) {

            String[] tokens = command.split(" - ");

            String operation = tokens[0];
            String item = tokens[1];

            if (operation.equals("Collect")) {

                boolean isItemExist = false;

                for (String str : items) {
                    if (str.equals(item)) {
                        isItemExist = true;
                        break;
                    }
                }

                if (!isItemExist) {
                    items.add(item);
                }

            } else if (operation.equals("Drop")) {

                for (int i = 0; i < items.size(); i++) {
                    if (items.get(i).equals(item)) {
                        items.remove(item);
                        break;
                    }
                }
            } else if (operation.equals("Combine Items")) {
                String[] elements = item.split(":");
                String oldItem = elements[0];
                String newItem = elements[1];

                int index = 0;
                boolean isItemExist = false;

                for (int i = 0; i < items.size(); i++) {
                    if (items.get(i).equals(oldItem)) {
                        isItemExist = true;
                        index = i;
                        break;
                    }
                }

                if (isItemExist) {
                    items.add(index, newItem);
                }
            } else if (operation.equals("Renew")) {

                for (int i = 0; i < items.size(); i++) {
                    if (items.get(i).equals(item)) {
                        String temp = items.get(i);
                        items.set(i, items.get(items.size() - 1));
                        items.set(items.size() - 1, temp);
                        break;
                    }
                }
            }

            command = scanner.nextLine();
        }

        printList(items);
    }


    public static void printList(List<String> items) {

        for (int i = 0; i < items.size(); i++) {
            System.out.printf("%s", items.get(i));

            if (i < items.size() - 1) {
                System.out.print(", ");
            }
        }
    }
}
