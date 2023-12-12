import java.util.ArrayDeque;
import java.util.Scanner;

public class _05_PrinterQueue {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();
        ArrayDeque<String> queue = new ArrayDeque<>();

        while (!text.equals("print")) {

            if (!text.equals("cancel")) {
                queue.offer(text);
            } else if (queue.isEmpty()) {
                System.out.println("Printer is on standby");
            } else {
                System.out.printf("Canceled %s%n", queue.poll());
            }

            text = scanner.nextLine();
        }

        for (String e: queue) {
            System.out.println(e);
        }
    }
}
