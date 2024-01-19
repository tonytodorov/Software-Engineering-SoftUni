import java.util.Arrays;
import java.util.Scanner;

public class _04_ArrayRotation {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine()
                .split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int rotation = Integer.parseInt(scanner.nextLine());

        while (rotation > 0){
            int temp = numbers[0];

            for (int i = 0; i < numbers.length - 1; i++) {
                numbers[i] = numbers[i + 1];
            }

            numbers[numbers.length - 1] = temp;
            rotation--;
        }

        for (int num: numbers) {
            System.out.printf("%d ", num);
        }
    }
}
