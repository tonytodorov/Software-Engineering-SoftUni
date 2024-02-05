import java.util.*;
import java.util.stream.Collectors;

public class _01_OffroadChallenge {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> stack = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(ArrayDeque::new, ArrayDeque::push, ArrayDeque::addAll);

        ArrayDeque<Integer> queue = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(ArrayDeque::new, ArrayDeque::offer, ArrayDeque::addAll);

        ArrayDeque<Integer> compareNumbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(ArrayDeque::new, ArrayDeque::offer, ArrayDeque::addAll);

        int countAltitude = 1;
        List<String> reachedAltitudes = new ArrayList<>();

        while (!stack.isEmpty() && !queue.isEmpty()) {
            int stackElement = stack.peek();
            int queueElement = queue.peek();
            int altitude = compareNumbers.peek();

            int subtractResult = stackElement - queueElement;

            if (subtractResult < altitude && countAltitude == 1) {
                System.out.printf("John failed to reach the top.%n" +
                        "John didn't reach any altitude.");
                return;
            } else if (subtractResult < altitude && countAltitude > 1) {
                System.out.printf("John did not reach: Altitude %d%n", countAltitude);
                System.out.printf("John failed to reach the top.%nReached altitudes: ");
                System.out.print(reachedAltitudes.stream().
                        map(Object::toString).
                        collect(Collectors.joining(", ")));
                return;
            } else if (subtractResult >= altitude) {
                stack.pop();
                queue.poll();
                compareNumbers.poll();
                System.out.printf("John has reached: Altitude %d%n", countAltitude);
                reachedAltitudes.add("Altitude " + countAltitude);
            }

            countAltitude += 1;
        }

        System.out.println("John has reached all the altitudes and managed to reach the top!");
    }
}
