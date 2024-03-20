import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _03_EnterNumbers {

    public static void main(String[] args) throws IllegalArgumentException {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = new ArrayList<>();

        int start = 1;
        int end = 100;

        int countNumbers = 0;

        while (countNumbers != 10) {
            try {
                int number = Integer.parseInt(scanner.nextLine());
                boolean isNumberInRange = readNumber(start, end, number);

                if (!isNumberInRange) {
                    throw new IllegalArgumentException();

                }

                start = number;
                numbers.add(number);
                countNumbers += 1;
            } catch (NumberFormatException e) {
                System.out.println("Invalid Number!");
            } catch (IllegalArgumentException e) {
                System.out.printf("Your number is not in range %d - 100!%n", start);
            }
        }

        System.out.println(numbers.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", ")));
    }

    private static boolean readNumber(int start, int end, int number) {
        return number > start && number < end;
    }

}