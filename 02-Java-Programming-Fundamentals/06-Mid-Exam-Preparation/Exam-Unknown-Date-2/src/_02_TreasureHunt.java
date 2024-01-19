import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _02_TreasureHunt {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        List<String> loot = Arrays.stream(scanner.nextLine()
                .split("\\|"))
                .collect(Collectors.toList());

        String command = scanner.nextLine();

        while (!command.equals("Yohoho!")) {

            String[] tokens = command.split(" ");
            String operation = tokens[0];

            if (operation.equals("Loot")) {
                addItem(loot, tokens);
            } else if (operation.equals("Drop")) {
                int index = Integer.parseInt(tokens[1]);
                boolean isIndexValid = isIndexValid(loot, index);

                if (!isIndexValid) {
                    command = scanner.nextLine();
                    continue;
                }

                String currentElement = loot.get(index);

                loot.remove(index);
                loot.add(currentElement);
            } else if (operation.equals("Steal")) {
                stealItem(loot, tokens);
            }

            command = scanner.nextLine();
        }

        if (loot.isEmpty()) {
            printList(loot);
            System.out.println("Failed treasure hunt.");
        } else {
            int sum = sumOfItemsLength(loot);
            double averageGain = 1.0 * sum / loot.size();
            System.out.printf("Average treasure gain: %.2f pirate credits.", averageGain);
        }

    }


    public static void addItem(List<String> loot, String[] tokens) {

        int index = 1;

        while (index < tokens.length) {
            String currentElement = tokens[index];
            boolean isItemExist = isItemExist(loot, currentElement);

            if (!isItemExist) {
                loot.add(0, tokens[index]);
            }

            index += 1;
        }
    }

    public static void stealItem(List<String> loot, String[] tokens) {

        int count = Integer.parseInt(tokens[1]);

        int startIndex = Math.abs(loot.size() - count);
        int endIndex = loot.size() - 1;

        for (int i = startIndex; i <= endIndex; i++) {
            if (startIndex == loot.size()) {
                break;
            }

            System.out.printf("%s", loot.get(startIndex));

            if (startIndex < loot.size() - 1) {
                System.out.print(", ");
            }

            loot.remove(startIndex);
        }
        System.out.println();
    }

    public static boolean isItemExist(List<String> loot, String element) {

        for (String str : loot) {
            if (str.equals(element)) {
                return true;
            }
        }

        return false;
    }

    public static boolean isIndexValid(List<String> loot, int index) {
        return index >= 0 && index <= loot.size() - 1;
    }

    public static int sumOfItemsLength(List<String> loot) {

        int sum = 0;

        for (int i = 0; i < loot.size(); i++) {
            String currentElement = loot.get(i);

            for (int j = 0; j < currentElement.length(); j++) {
                sum += 1;
            }

        }

        return sum;
    }
    
    public static void printList(List<String> loot) {
        for (int i = 0; i < loot.size(); i++) {
            System.out.printf("%s", loot.get(i));

            if (i < loot.size() - 1) {
                System.out.print(", ");
            }
        }
    }
}
