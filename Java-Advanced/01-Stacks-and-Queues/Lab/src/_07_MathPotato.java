import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class _07_MathPotato {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] names = scanner.nextLine().split(" ");
        int steps = Integer.parseInt(scanner.nextLine());

        PriorityQueue<String> name = new PriorityQueue<>();

        Collections.addAll(name, names);

        int currentSteps = 1;

        while (name.size() > 1) {
            for (int i = 0; i < steps; i++) {
                String kid = name.poll();
                name.offer(kid);
            }

            if (isPrime(currentSteps)) {
                System.out.printf("Prime %s%n", name.peek());
            } else {
                String removed = name.poll();
                System.out.printf("Removed %s%n", removed);
            }

            currentSteps += 1;
        }

        System.out.printf("Last is %s", name.peek());
    }

    public static boolean isPrime(int num) {

        if (num == 1) {
            return false;
        }

        for (int i = 2; i < num; i++) {
            if (num % i == 0) {
                return false;
            }
        }

        return true;
    }
}