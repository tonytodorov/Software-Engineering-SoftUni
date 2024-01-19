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

                boolean isItemExist = isItemExist(items, item);

                if (!isItemExist) {
                    items.add(item);
                }
            } else if (operation.equals("Drop")) {

                boolean isItemExist = isItemExist(items, item);

                if (isItemExist) {
                    items.remove(item);
                }
            } else if (operation.equals("Combine Items")) {
                String[] token = item.split(":");
                String oldItem = token[0];
                String newItem = token[1];

                boolean isOldItemExist = isItemExist(items, oldItem);

                if (isOldItemExist) {
                    int oldItemIndex = itemIndex(items, oldItem);
                    items.add(oldItemIndex + 1, newItem);
                }
            } else if (operation.equals("Renew")) {
                boolean isItemExist = isItemExist(items, item);

                if (isItemExist) {
                    int itemIndex = itemIndex(items, item);
                    items.add(item);
                    items.remove(itemIndex);
                }
            }

            command = scanner.nextLine();
        }

        printList(items);
    }

    public static boolean isItemExist(List<String> items, String item) {

        for (String element : items) {
            if (element.equals(item)) {
                return true;
            }
        }

        return false;
    }

    public static int itemIndex(List<String> items, String item) {

        int index = 0;

        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).equals(item)) {
                index = i;
                break;
            }
        }

        return index;
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
