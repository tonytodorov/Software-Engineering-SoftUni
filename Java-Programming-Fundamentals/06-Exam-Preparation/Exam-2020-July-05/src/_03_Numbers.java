import java.util.*;
import java.util.stream.Collectors;

public class _03_Numbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine()
                .split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());


        if (numbers.size() == 1) {
            System.out.println("No");
            return;
        }

        int sum = 0;
        double average;

        for (Integer number : numbers) {
            sum += number;
        }

        average = 1.0 * sum / numbers.size();
        List<Integer> result = new ArrayList<>();

        for (Integer number : numbers) {
            if (number > average) {
                result.add(number);
            }
        }

        result.sort(Collections.reverseOrder());

        int topNumbers = 0;

        for (Integer integer : result) {
            if (integer != 0) {
                topNumbers++;
                System.out.printf("%d ", integer);
            }

            if (topNumbers == 5) {
                break;
            }
        }
    }
}
