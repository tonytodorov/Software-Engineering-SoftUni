import java.util.Arrays;
import java.util.Scanner;

public class _03_TwoDigitsElements {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine()
                .split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int countTwoDigits = 0;

        for (int element: numbers) {
            if (element >= 10 && element <= 99) {
                countTwoDigits++;
            }
        }

        System.out.printf("Elements with two digits are: %d", countTwoDigits);
    }
}
