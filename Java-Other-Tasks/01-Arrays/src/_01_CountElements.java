import java.util.Arrays;
import java.util.Scanner;

public class _01_CountElements {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine()
                .split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int num = Integer.parseInt(scanner.nextLine());

        int countNum = 0;

        for (int element: numbers) {
            if (element == num) {
                countNum++;
            }
        }

        System.out.printf("Elements that equal on %d are: %d", num, countNum);
    }
}
