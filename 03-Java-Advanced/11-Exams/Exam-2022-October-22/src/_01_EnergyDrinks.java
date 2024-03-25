import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _01_EnergyDrinks {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Deque<Integer> caffeineStack = new ArrayDeque<>();
        Deque<Integer> drinkQueue = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine()
                .split(",\\s+"))
                .map(Integer::parseInt)
                .forEach(caffeineStack::push);

        Arrays.stream(scanner.nextLine()
                .split(",\\s+"))
                .map(Integer::parseInt)
                .forEach(drinkQueue::offer);

        int totalCaffeine = 0;

        while (!caffeineStack.isEmpty() && !drinkQueue.isEmpty()) {
            int queue = drinkQueue.poll();
            int stack = caffeineStack.pop();

            int currentCaffeine = queue * stack;

            if (totalCaffeine + currentCaffeine <= 300) {
                totalCaffeine += currentCaffeine;
            } else {
                drinkQueue.offer(queue);
                if (totalCaffeine - 30 >= 0) {
                    totalCaffeine -= 30;
                }
            }
        }

        if (!drinkQueue.isEmpty()) {
            System.out.printf("Drinks left: %s%n", printDeque(drinkQueue));
        } else {
            System.out.println("At least Stamat wasn't exceeding the maximum caffeine.");
        }

        System.out.printf("Stamat is going to sleep with %d mg caffeine.", totalCaffeine);
    }

    public static String printDeque(Deque<Integer> deque) {
        return deque.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", "));
    }
}
