import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class _03_MaximumElements {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            String[] command = scanner.nextLine().split("\\s+");
            String operation = command[0];

            if ("1".equals(operation)) {
                int number = Integer.parseInt(command[1]);
                stack.push(number);
            } else if ("2".equals(operation)) {
                stack.pop();
            } else if ("3".equals(operation)) {
                System.out.println(Collections.max(stack));
            }
        }
    }
}
