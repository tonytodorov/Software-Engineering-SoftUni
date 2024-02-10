import java.util.*;
import java.util.stream.Collectors;

public class _01_TempleOfDoom {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Deque<Integer> toolsQueue = Arrays.stream(scanner.nextLine()
                .split("\\s+"))
                .map(Integer::parseInt)
                .collect(ArrayDeque::new, ArrayDeque::offer, ArrayDeque::addAll);

        Deque<Integer> substanceStack = Arrays.stream(scanner.nextLine()
                .split("\\s+"))
                .map(Integer::parseInt)
                .collect(ArrayDeque::new, ArrayDeque::push, ArrayDeque::addAll);

        List<Integer> challenges = Arrays.stream(scanner.nextLine()
                .split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        while (!toolsQueue.isEmpty() && !substanceStack.isEmpty()) {
            int queueElement = toolsQueue.poll();
            int stackElement = substanceStack.pop();

            int res = queueElement * stackElement;

            if (challenges.isEmpty()) {
                break;
            }

            if (challenges.contains(res)) {
                challenges.removeIf(challenge -> challenge == res);
            } else {
                queueElement += 1;
                toolsQueue.offer(queueElement);

                stackElement -= 1;

                if (stackElement != 0) {
                    substanceStack.push(stackElement);
                }
            }
        }

        if (!challenges.isEmpty()) {
            System.out.println("Harry is lost in the temple. Oblivion awaits him.");
        } else {
            System.out.println("Harry found an ostracon, which is dated to the 6th century BCE.");
        }

        if (!toolsQueue.isEmpty()) {
            printDeque("Tools", toolsQueue);
        }

        if (!substanceStack.isEmpty()) {
            printDeque("Substances", substanceStack);
        }

        if (!challenges.isEmpty()) {
            System.out.printf("Challenges: %s", challenges.stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining(", ")));
        }
    }

    public static void printDeque(String format, Deque<Integer> deque) {
        System.out.printf("%s: %s%n", format, deque.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", ")));
    }
}
