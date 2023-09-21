import java.util.Arrays;
import java.util.Scanner;

public class _05_EvenOddSubtraction {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine()
                .split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int sumEvenNumbers = 0;
        int sumOddNumbers = 0;

        for (int number : numbers) {
            if (number % 2 == 0) {
                sumEvenNumbers += number;
            } else {
                sumOddNumbers += number;
            }
        }

        int subtract = sumEvenNumbers - sumOddNumbers;
        System.out.println(subtract);
    }
}
