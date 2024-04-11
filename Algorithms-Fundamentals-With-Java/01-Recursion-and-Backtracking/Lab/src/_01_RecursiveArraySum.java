import java.util.Arrays;
import java.util.Scanner;

public class _01_RecursiveArraySum {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine()
                .split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        System.out.println(sumNumbers(numbers, 0));
    }

    private static int sumNumbers(int[] numbers, int index) {
        if (index == numbers.length) {
            return 0;
        }

        return numbers[index] + sumNumbers(numbers, index + 1);
    }
}
