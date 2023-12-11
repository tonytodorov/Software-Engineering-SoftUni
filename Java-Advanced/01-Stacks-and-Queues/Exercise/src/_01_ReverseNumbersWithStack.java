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

        for (int num : input) {
            numbers.push(num);
        }


    }
}
