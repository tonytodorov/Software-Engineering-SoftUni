import java.util.Arrays;
import java.util.Scanner;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.stream.IntStream;

public class _06_FindEvenOrOdds {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] input = Arrays.stream(scanner.nextLine()
                .split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        String condition = scanner.nextLine();

        int lowerBound = input[0];
        int upperBound = input[1];

        if (condition.equals("odd")) {
            printNumbers(lowerBound, upperBound, v -> v % 2 != 0);
        } else {
            printNumbers(lowerBound, upperBound, v -> v % 2 == 0);
        }

    }

    public static void printNumbers(int start, int end, IntPredicate predicate) {
        IntStream.rangeClosed(start, end)
                .filter(predicate)
                .forEach(n -> System.out.print(n + " "));
    }
}
