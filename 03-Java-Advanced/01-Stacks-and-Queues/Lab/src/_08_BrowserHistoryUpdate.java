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
                back(command, stack);
            } else {
                forward(command, queue);
            }

            command = scanner.nextLine();
        }
    }

    public static void back(String command, ArrayDeque<String> stack) {

        if (!stack.isEmpty() && stack.size() != 1) {
            stack.pop();
        } else if (stack.isEmpty()){
            System.out.println("no previous URLs");
        } else{
            stack.push(command);
            System.out.println(stack.peek());
        }

    }

    public static void forward(String command, ArrayDeque<String> queue) {

        if (!queue.isEmpty() && queue.size() != 1) {
            queue.clear();
        } else if (queue.isEmpty()){
            System.out.println("no previous URLs");
        } else{
            queue.push(command);
            System.out.println(queue.peek());
        }
    }
}
