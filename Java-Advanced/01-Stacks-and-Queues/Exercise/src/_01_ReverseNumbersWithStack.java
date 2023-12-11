import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class _01_ReverseNumbersWithStack {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] input = Arrays.stream(scanner.nextLine()
                .split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        ArrayDeque<Integer> numbers = new ArrayDeque<>();

        for (Integer num : input) {
            numbers.push(num);
        }

        for (int i = 0; i < numbers.size(); i++) {
            int num = numbers.poll();
            numbers.push(num);
        }

        for (Integer num: numbers) {
            System.out.print(num + " ");
        }
    }
}
