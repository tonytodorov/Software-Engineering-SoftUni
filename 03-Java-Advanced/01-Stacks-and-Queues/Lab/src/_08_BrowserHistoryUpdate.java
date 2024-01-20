import java.util.ArrayDeque;
import java.util.Scanner;

public class _08_BrowserHistoryUpdate {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();

        ArrayDeque<String> stack = new ArrayDeque<>();
        ArrayDeque<String> queue = new ArrayDeque<>();

        while (!command.equals("Home")) {

            if (command.equals("back")) {
               if (!stack.isEmpty()) {
                   stack.pop();
                   System.out.println(stack.peek());
               } else {
                   System.out.println("no previous URLs");
               }
            } else if (command.equals("forward")) {
                if (!queue.isEmpty()) {
                    queue.poll();
                    System.out.println(queue.peek());
                } else {
                    System.out.println("no next URLs");
                }
            } else {
                stack.push(command);
                queue.offer(command);
                System.out.println(command);
            }

            command = scanner.nextLine();
        }
    }
}
