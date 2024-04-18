import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class _08_CustomComparator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine()
                .split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        Predicate<Integer> evenNumbers = v -> v % 2 == 0;
        Predicate<Integer> oddNumbers = v -> v % 2 != 0;

        List<Integer> even = numbers.stream()
                .filter(evenNumbers)
                .collect(Collectors.toList());

        List<Integer> odd = numbers.stream()
                .filter(oddNumbers)
                .collect(Collectors.toList());

        Collections.sort(even);
        Collections.sort(odd);

        even.forEach(v -> System.out.print(v + " "));
        odd.forEach(v -> System.out.print(v + " "));
    }

}
