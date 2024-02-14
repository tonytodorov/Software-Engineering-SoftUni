import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class _01_KAT {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Deque<Integer> platesQueue = new ArrayDeque<>();
        Deque<Integer> carsStack = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine()
                .split(",\\s+"))
                .map(Integer::parseInt)
                .forEach(platesQueue::offer);

        Arrays.stream(scanner.nextLine()
                .split(",\\s+"))
                .map(Integer::parseInt)
                .forEach(carsStack::push);

        int countCars = 0;
        int countDays = 0;

        while (!platesQueue.isEmpty() && !carsStack.isEmpty()) {
            int queue = platesQueue.poll();
            int stack = carsStack.pop();

            int plates = queue / 2;

            if (plates == stack) {
                countCars += stack;
            } else {
                countCars += plates;
                carsStack.push(Math.abs(stack - plates));
            }

            countDays++;
        }

        System.out.printf("%d cars were registered for %d days!%n", countCars, countDays);

        if (platesQueue.isEmpty()) {
            System.out.println("Good job! There is no queue in front of the KAT!%n");
        } else {
            System.out.printf("%d license plates remain!", platesQueue.stream().reduce(0, Integer::sum));
        }
    }
}
