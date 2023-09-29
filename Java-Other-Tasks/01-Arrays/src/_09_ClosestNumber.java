import java.util.Arrays;
import java.util.Scanner;

public class _09_ClosestNumber {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine()
                .split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int num = Integer.parseInt(scanner.nextLine());

        int minDifference = Integer.MAX_VALUE;
        int closestElement = 0;

        for (int number : numbers) {
            int difference = Math.abs(number - num);

            if (difference < minDifference) {
                minDifference = difference;
                closestElement = number;
            }
        }

        int index = 0;

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == closestElement) {
                index = i;
                break;
            }
        }

        System.out.printf("Closest element to number is: %d%nIndex: %d", closestElement, index);
    }
}
