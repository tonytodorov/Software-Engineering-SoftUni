import java.util.Arrays;
import java.util.Scanner;

public class _12_SwapFirstAndBiggestElement {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine()
                .split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int maxElement = Integer.MIN_VALUE;
        int maxElementIndex = 0;

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] > maxElement) {
                maxElement = numbers[i];
                maxElementIndex = i;
            }
        }

        int temp = numbers[0];
        numbers[0] = maxElement;
        numbers[maxElementIndex] = temp;

        System.out.println(Arrays.toString(numbers));
    }
}
