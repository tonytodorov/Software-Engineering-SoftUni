import java.util.Arrays;
import java.util.Scanner;

public class _02_ElementsInRange {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine()
                .split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int leftBound = Integer.parseInt(scanner.nextLine());
        int rightBound = Integer.parseInt(scanner.nextLine());

        int countNum = 0;

        for (int element: numbers) {
            if (element > leftBound && element < rightBound) {
                countNum++;
            }
        }

        System.out.printf("Elements in range (%d, %d) are: %d",leftBound, rightBound, countNum);
    }
}
