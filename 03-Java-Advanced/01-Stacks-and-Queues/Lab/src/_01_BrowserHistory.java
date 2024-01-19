import java.util.ArrayDeque;
import java.util.Scanner;

public class _01_BrowserHistory {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();
        ArrayDeque<String> stack = new ArrayDeque<>();

        while (!command.equals("Home")) {

            if (command.equals("back")) {
                if (!stack.isEmpty() && stack.size() != 1) {
                    stack.pop();
                } else {
                    System.out.println("no previous URLs");
                    command = scanner.nextLine();
                    continue;
                }
            } else {
                stack.push(command);
            }

            System.out.println(stack.peek());
            command = scanner.nextLine();
        }
    }
}
