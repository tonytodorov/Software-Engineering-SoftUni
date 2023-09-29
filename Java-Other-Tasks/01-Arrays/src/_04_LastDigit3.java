import java.util.Arrays;
import java.util.Scanner;

public class _04_LastDigit3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine()
                .split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int countNum = 0;

        for (int element: numbers) {
            int lastDigit = element % 10;

            if (lastDigit == 3) {
                countNum++;
            }
        }

        System.out.printf("Numbers with last digit 3 are: %d", countNum);
    }
}
