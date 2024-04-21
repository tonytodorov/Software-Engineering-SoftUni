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
                numbers = numbers.stream().map(num -> num + 1).toList();
            } else if ("multiply".equals(input)) {
                numbers = numbers.stream().map(num -> num * 2).toList();
            } else if ("subtract".equals(input)) {
                numbers = numbers.stream().map(num -> num - 1).toList();
            } else {
                numbers.forEach(System.out::println);
            }

            input = scanner.nextLine();
        }
    }
}
