import java.util.Arrays;
import java.util.Scanner;

public class _06_NewArray {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine()
                .split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int num = Integer.parseInt(scanner.nextLine());

        int[] array = new int[numbers.length];

        for (int i = 0; i < array.length; i++) {
            array[i] = numbers[i] % num;
        }

        System.out.printf("New Array: %s%n", Arrays.toString(array));
    }
}
