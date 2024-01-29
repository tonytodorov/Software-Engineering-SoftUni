import java.util.Arrays;
import java.util.OptionalInt;
import java.util.Scanner;

public class _03_CustomMinFunction {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine()
                .split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        OptionalInt min = Arrays.stream(numbers).min();

        System.out.println(min.getAsInt());
    }
}
