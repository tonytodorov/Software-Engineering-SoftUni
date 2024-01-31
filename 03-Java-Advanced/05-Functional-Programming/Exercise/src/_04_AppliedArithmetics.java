import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class _04_AppliedArithmetics {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine()
                .split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        String input = scanner.nextLine();

        while (!"end".equals(input)) {
            if ("add".equals(input)) {
                Function<Integer, Integer> add = v -> v + 1;
                numbers.replaceAll(add::apply);
            } else if ("multiply".equals(input)) {
                Function<Integer, Integer> multiply = v -> v * 2;
                numbers.replaceAll(multiply::apply);
            } else if ("subtract".equals(input)) {
                Function<Integer, Integer> subtract = v -> v - 1;
                numbers.replaceAll(subtract::apply);
            } else {
                Consumer<Integer> printer = v -> System.out.printf("%d ", v);
                numbers.forEach(printer);
            }

            input = scanner.nextLine();
        }
    }
}
