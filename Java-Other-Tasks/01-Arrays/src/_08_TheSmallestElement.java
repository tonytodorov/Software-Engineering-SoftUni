import java.util.Arrays;
import java.util.Scanner;

public class _08_TheSmallestElement {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream((scanner.nextLine())
                .split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int minElement = Integer.MAX_VALUE;

        for (int number : numbers) {
            if (number < minElement) {
                minElement = number;
            }
        }

        int index = 0;

        for (int i = numbers.length - 1; i >= 0; i--) {
            if (numbers[i] == minElement) {
                index = i;
                break;
            }
        }


        System.out.printf("Smallest element in array: %d%n Index: %d", minElement, index);
    }
}
