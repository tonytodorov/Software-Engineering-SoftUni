import java.util.Arrays;
import java.util.Scanner;

public class _07_TheBiggestElement {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine()
                .split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int maxElement = Integer.MIN_VALUE;

        for (int number : numbers) {
            if (number > maxElement) {
                maxElement = number;
            }
        }

        int index = 0;

        for (int i = 0; i < numbers.length; i++) {
            if(numbers[i] == maxElement) {
                index = i;
                break;
            }
        }

        System.out.printf("Biggest element in array: %d%nIndex: %d", maxElement, index);
    }
}
