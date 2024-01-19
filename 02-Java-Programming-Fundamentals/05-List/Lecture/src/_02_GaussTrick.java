import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _02_GaussTrick {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine()
                .split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < numbers.size() / 2; i++) {
            result.add(numbers.get(i) + numbers.get(numbers.size() - 1 - i));
        }

        if (numbers.size() % 2 != 0) {
            result.add(numbers.get((numbers.size() - 1) / 2));
        }

        for (int num: result) {
            System.out.printf("%d ", num);
        }
    }
}
