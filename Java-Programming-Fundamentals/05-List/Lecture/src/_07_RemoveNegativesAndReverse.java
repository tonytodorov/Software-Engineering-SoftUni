import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _07_RemoveNegativesAndReverse {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine()
                .split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        for (int i = 0; i < numbers.size(); i++) {
            if(numbers.get(i) < 0) {
                numbers.remove(i);
                i = -1;
            }
        }

        if (numbers.size() <= 0) {
            System.out.println("empty");
            return;
        }

        for (int i = 0; i < numbers.size() / 2; i++) {
            int temp = numbers.get(i);
            numbers.set(i, numbers.get(numbers.size() - 1 - i));
            numbers.set(numbers.size() - 1 - i, temp);
        }

        for (int num: numbers) {
            System.out.printf("%d ", num);
        }
    }
}
