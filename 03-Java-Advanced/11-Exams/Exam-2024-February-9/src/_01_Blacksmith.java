import java.util.*;
import java.util.stream.Collectors;

public class _01_Blacksmith {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Deque<Integer> steelQueue = new ArrayDeque<>();
        Deque<Integer> carbonQueue = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine()
                .split("\\s+"))
                .map(Integer::parseInt)
                .forEach(steelQueue::offer);

        Arrays.stream(scanner.nextLine()
                .split("\\s+"))
                .map(Integer::parseInt)
                .forEach(carbonQueue::push);

        Map<Integer, String> swords = new LinkedHashMap<>();
        swords.put(70, "Gladius");
        swords.put(80, "Shamshir");
        swords.put(90, "Katana");
        swords.put(110, "Sabre");

        Map<String, Integer> craftedSwords = new TreeMap<>();
        int totalSwords = 0;

        while (!steelQueue.isEmpty() && !carbonQueue.isEmpty()) {
            int queue = steelQueue.poll();
            int stack = carbonQueue.pop();

            boolean isCrafted = false;
            int sum = queue + stack;

            for (Map.Entry<Integer, String> entry: swords.entrySet()) {
                if (entry.getKey() == sum) {
                    totalSwords++;
                    craftedSwords.putIfAbsent(entry.getValue(), 0);
                    craftedSwords.put(entry.getValue(), craftedSwords.get(entry.getValue()) + 1);
                    isCrafted = true;
                    break;
                }
            }

            if (!isCrafted) {
                stack += 5;
                carbonQueue.push(stack);
            }
        }

        if (totalSwords > 0) {
            System.out.printf("You have forged %d swords.%n", totalSwords);
        } else {
            System.out.println("You did not have enough resources to forge a sword.");
        }

        if (!steelQueue.isEmpty()) {
            System.out.printf("Steel left: %s%n", printDeque(steelQueue));
        } else {
            System.out.println("Steel left: none");
        }

        if (!carbonQueue.isEmpty()) {
            System.out.printf("Carbon left: %s%n", printDeque(carbonQueue));
        } else {
            System.out.println("Carbon left: none");
        }

        printMap(craftedSwords);
    }

    public static String printDeque(Deque<Integer> deque) {
        return deque.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", "));
    }

    public static void printMap(Map<String, Integer> map) {
        for (Map.Entry<String, Integer> entry: map.entrySet()) {
            System.out.printf("%s: %d%n", entry.getKey(), entry.getValue());
        }
    }
}
