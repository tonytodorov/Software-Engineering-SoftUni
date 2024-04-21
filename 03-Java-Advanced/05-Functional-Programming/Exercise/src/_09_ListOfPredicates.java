import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _09_ListOfPredicates {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int upperBound = Integer.parseInt(scanner.nextLine());

        List<Integer> numbers = Arrays.stream(scanner.nextLine()
                .split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        List<Integer> validNumbers = new ArrayList<>();

        for (int i = 1; i <= upperBound; i++) {
            int currentDivider = i;

            if (numbers.stream().allMatch(num -> currentDivider % num == 0)) {
                validNumbers.add(i);
            }
        }

        validNumbers.forEach(number -> System.out.print(number + " "));
    }
}
