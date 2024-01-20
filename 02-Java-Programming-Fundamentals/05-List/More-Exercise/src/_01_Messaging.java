import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _01_Messaging {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine()
                .split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        StringBuilder text = new StringBuilder(scanner.nextLine());
        StringBuilder word = new StringBuilder();

        for (Integer num: numbers) {

            int sum = String.valueOf(num)
                    .chars()
                    .map(Character::getNumericValue)
                    .sum();

            if (sum > text.length() - 1) {
                int currentIndex = sum - text.length();
                char currentSymbol = text.charAt(currentIndex);
                word.append(currentSymbol);

                text.deleteCharAt(currentIndex);
            } else {
                char currentSymbol = text.charAt(sum);
                word.append(currentSymbol);

                text.deleteCharAt(sum);
            }
        }

        System.out.println(word);
    }
}
