import java.util.Arrays;
import java.util.Scanner;

public class _01_RecursiveArraySum {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine()
                .split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();


        System.out.println(sum(numbers, numbers.length - 1));
    }

    private static int sum(int[] numbers, int index) {
        if (index == 0) {
            return 1;
        }

        return sum(numbers, index) + sum(numbers, index - 1);
    }
}
