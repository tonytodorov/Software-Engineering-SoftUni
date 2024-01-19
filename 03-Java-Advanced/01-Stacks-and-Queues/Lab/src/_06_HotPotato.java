import java.util.ArrayDeque;
import java.util.Scanner;

public class _06_HotPotato {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] names = scanner.nextLine().split(" ");
        int steps = Integer.parseInt(scanner.nextLine());

        ArrayDeque<String> queue = new ArrayDeque<>();

        for (String name : names) {
            queue.offer(name);
        }

        while (queue.size() > 1) {
            for (int i = 1; i < steps; i++) {
                String kid = queue.poll();
                queue.offer(kid);
            }

            String removedChild = queue.poll();
            System.out.printf("Removed %s%n", removedChild);
        }

        System.out.printf("Last is %s", queue.peek());
    }
}