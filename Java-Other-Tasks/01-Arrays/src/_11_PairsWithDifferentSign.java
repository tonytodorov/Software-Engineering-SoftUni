import java.util.Arrays;
import java.util.Scanner;

public class _11_PairsWithDifferentSign {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine()
                .split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int countPairs = 0;

        for (int i = 0; i < numbers.length - 1; i++) {
            if (numbers[i] > 0 && numbers[i + 1] < 0 || numbers[i] < 0 && numbers[i + 1] > 0) {
                countPairs++;
            }
        }

        System.out.printf("Total pairs with different sign is: %d", countPairs);
    }
}
