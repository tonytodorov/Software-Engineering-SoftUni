import java.util.Arrays;
import java.util.Scanner;

public class _10_MostDistantNumber {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine()
                .split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int num = Integer.parseInt(scanner.nextLine());
        
        int maxDifference = Integer.MIN_VALUE;
        int mostDistantElement = 0;

        for (int number : numbers) {
            int difference = Math.abs(number - num);

            if (difference > maxDifference) {
                maxDifference = difference;
                mostDistantElement = number;
            }
        }

        int index = 0;

        for (int i = numbers.length - 1; i >= 0; i--) {
            if (numbers[i] == mostDistantElement) {
                index = i;
                break;
            }
        }


        System.out.printf("Most distant elements is: %d%nIndex: %d", mostDistantElement, index);
    }
}
