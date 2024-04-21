import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _07_FindTheSmallestElement {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine()
                .split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int smallestNumber = smallestNumber(numbers);
        System.out.println(smallestNumber);
    }

    private static int smallestNumber(List<Integer> numbers) {
        int index = 0;
        int MIN_VALUE = Integer.MAX_VALUE;

        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i) < MIN_VALUE) {
                MIN_VALUE = numbers.get(i);
            }

            if (MIN_VALUE == numbers.get(i)) {
                index = i;
            }
        }

        return index;
    }
}
