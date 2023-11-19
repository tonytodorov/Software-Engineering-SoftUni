import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _02_ShoppingList {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> groceries = Arrays.stream(scanner.nextLine()
                .split("!"))
                .collect(Collectors.toList());

        String command = scanner.nextLine();

        while (!command.equals("Go Shopping!")) {

            String[] tokens = command.split(" ");
            String operation = tokens[0];
            String product = tokens[1];

            int index = 0;
            index = groceryIndex(groceries, product, index);

            boolean isProductExist = isGroceryExist(groceries, product);

            switch (operation) {
                case "Urgent":
                    if (!isProductExist) {
                        groceries.add(0, product);
                    }
                    break;
                case "Unnecessary":
                    if (isProductExist) {
                        groceries.remove(product);
                    }
                    break;
                case "Correct":
                    String newProduct = tokens[2];
                    if (isProductExist) {
                        groceries.set(index, newProduct);
                    }
                    break;
                case "Rearrange":
                    if (isProductExist) {
                        groceries.remove(index);
                        groceries.add(product);
                    }
                    break;
            }

            command = scanner.nextLine();
        }

        printList(groceries);
    }


    public static boolean isGroceryExist(List<String> groceries, String product) {
        for (String grocery : groceries) {
            if (grocery.equals(product)) {
               return true;
            }
        }

        return false;
    }

    public static int groceryIndex(List<String> groceries, String product, int index) {
        for (int i = 0; i < groceries.size(); i++) {
            if (groceries.get(i).equals(product)) {
                index = i;
            }
        }

        return index;
    }

    public static void printList(List<String> groceries) {

        for (int i = 0; i < groceries.size(); i++) {
            System.out.printf("%s", groceries.get(i));

            if (i < groceries.size() - 1) {
                System.out.print(", ");
            }
        }
    }
}
