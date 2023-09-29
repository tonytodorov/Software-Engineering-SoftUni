import java.util.Arrays;
import java.util.Scanner;

public class _13_SwapFirstAndSmallestElement {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine()
                .split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int minElement = Integer.MAX_VALUE;
        int minElementIndex = 0;

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] < minElement) {
                minElement = numbers[i];
                minElementIndex = i;
            }
        }

        int temp = numbers[0];
        numbers[0] = minElement;
        numbers[minElementIndex] = temp;

        System.out.println(Arrays.toString(numbers));
    }
}
