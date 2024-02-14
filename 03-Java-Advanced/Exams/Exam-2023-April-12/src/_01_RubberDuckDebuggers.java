import java.util.*;

public class _01_RubberDuckDebuggers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Deque<Integer> timeQueue = Arrays.stream(scanner.nextLine()
                .split("\\s+"))
                .map(Integer::parseInt)
                .collect(ArrayDeque::new, ArrayDeque::offer, ArrayDeque::addAll);

        Deque<Integer> tasksStack = Arrays.stream(scanner.nextLine()
                .split("\\s+"))
                .map(Integer::parseInt)
                .collect(ArrayDeque::new, ArrayDeque::push, ArrayDeque::addAll);

        Map<String, Integer> duck = new LinkedHashMap<>();

        duck.put("Darth Vader Ducky", 0);
        duck.put("Thor Ducky", 0);
        duck.put("Big Blue Rubber Ducky", 0);
        duck.put("Small Yellow Rubber Ducky", 0);

        while (!timeQueue.isEmpty() && !tasksStack.isEmpty()) {
            int queue = timeQueue.poll();
            int stack = tasksStack.pop();

            int result = queue * stack;

            if (result <= 60) {
                duck.put("Darth Vader Ducky", duck.get("Darth Vader Ducky") + 1);
            } else if (result <= 120) {
                duck.put("Thor Ducky", duck.get("Thor Ducky") + 1);
            } else if (result <= 180) {
                duck.put("Big Blue Rubber Ducky", duck.get("Big Blue Rubber Ducky") + 1);
            } else if (result <= 240) {
                duck.put("Small Yellow Rubber Ducky", duck.get("Small Yellow Rubber Ducky") + 1);
            } else {
                stack -= 2;
                tasksStack.push(stack);
                timeQueue.offer(queue);
            }
        }

        System.out.println("Congratulations, all tasks have been completed! Rubber ducks rewarded:");

        duck.forEach((key, value) -> System.out.printf("%s: %d%n", key, value));
    }
}
