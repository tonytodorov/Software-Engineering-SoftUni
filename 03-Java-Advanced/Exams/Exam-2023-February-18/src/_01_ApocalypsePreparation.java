import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class _01_ApocalypsePreparation {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Deque<Integer> textileQueue = new ArrayDeque<>();
        Deque<Integer> medicamentStack = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine()
                        .split("\\s+"))
                .map(Integer::parseInt)
                .forEach(textileQueue::offer);

        Arrays.stream(scanner.nextLine()
                        .split("\\s+"))
                .map(Integer::parseInt)
                .forEach(medicamentStack::push);

        Map<String, Integer> healingItems = new HashMap<>();
        healingItems.put("Patch", 0);
        healingItems.put("Bandage", 0);
        healingItems.put("MedKit", 0);

        while (!textileQueue.isEmpty() && !medicamentStack.isEmpty()) {
            int queue = textileQueue.poll();
            int stack = medicamentStack.pop();

            int sum = queue + stack;

            if (sum == 30) {
                healingItems.put("Patch", healingItems.get("Patch") + 1);
            } else if (sum == 40) {
                healingItems.put("Bandage", healingItems.get("Bandage") + 1);
            } else if (sum == 100) {
                healingItems.put("MedKit", healingItems.get("MedKit") + 1);
            } else if (sum > 100) {
                healingItems.put("MedKit", healingItems.get("MedKit") + 1);
                int diff = sum - 100;
                medicamentStack.push(medicamentStack.pop() + diff);
            } else {
                stack += 10;
                medicamentStack.push(stack);
            }
        }

        if (textileQueue.isEmpty() && medicamentStack.isEmpty()) {
            System.out.println("Textiles and medicaments are both empty.");
        } else if (textileQueue.isEmpty()) {
            System.out.println("Textiles are empty.");
        } else {
            System.out.println("Medicaments are empty.");
        }

        Stream<Map.Entry<String, Integer>> sorted = healingItems.entrySet()
                .stream()
                .filter(entry -> entry.getValue() != 0)
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()));

        sorted.forEach(entry -> System.out.printf("%s - %d%n", entry.getKey(), entry.getValue()));

        if (!textileQueue.isEmpty()) {
            System.out.printf("Textiles left: %s", print(textileQueue));
        }

        if (!medicamentStack.isEmpty()) {
            System.out.printf("Medicaments left: %s", print(medicamentStack));
        }
    }

    public static String print(Deque<Integer> deque) {
        return deque.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", "));
    }
}
