import java.util.ArrayDeque;
import java.util.Scanner;

public class _03_DecimalToBinaryConverter {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        if (number == 0) {
            System.out.println(0);
            return;
        }

        while (number > 0) {
            if (number % 2 == 0) {
                stack.push(0);
            } else {
                stack.push(1);
            }
            number /= 2;
        }

        for (Integer num: stack) {
            System.out.print(num);
        }
    }
}
