import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _03_MemoryGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> numbers = Arrays.stream(scanner.nextLine()
                .split(" "))
                .collect(Collectors.toList());

        String command = scanner.nextLine();
        int moves = 0;

        while (!command.equals("end")) {
            moves++;
            String[] token = command.split(" ");

            int firstIndex = Integer.parseInt(token[0]);
            int secondIndex = Integer.parseInt(token[1]);

            boolean isIndexesOutOfRange = isIndexesOutOfRange(numbers, firstIndex, secondIndex);

            if (isIndexesOutOfRange) {
                System.out.println("Invalid input! Adding additional elements to the board");

                int startIndex = numbers.size() / 2;
                numbers.add(startIndex, -moves + "a");
                numbers.add(startIndex + 1, -moves + "a");

            } else if (numbers.get(firstIndex).equals(numbers.get(secondIndex))) {

                System.out.printf("Congrats! You have found matching elements - %s!%n", numbers.get(firstIndex));

                numbers.remove(firstIndex);

                if (secondIndex != 0) {
                    numbers.remove(secondIndex - 1);
                } else {
                    numbers.remove(secondIndex);
                }

            } else {
                System.out.println("Try again!");
            }

            boolean isListEmpty = isListEmpty(numbers);

            if (isListEmpty) {
                System.out.printf("You have won in %d turns!", moves);
                return;
            }

            command = scanner.nextLine();
        }

        boolean isElementsExist = isElementExist(numbers);

        if (isElementsExist) {
            System.out.println("Sorry you lose :(");
            printArr(numbers);
        }

    }

    public static boolean isListEmpty(List<String> numbers) {
        return numbers.size() == 0;
    }

    public static boolean isElementExist(List<String> numbers) {
        return numbers.size() > 0;
    }

    public static boolean isIndexesOutOfRange(List<String> numbers, int firstIndex, int secondIndex) {
        return (firstIndex < 0 || firstIndex > numbers.size())
                || (secondIndex < 0 || secondIndex > numbers.size())
                || (firstIndex == secondIndex);
    }

    public static void printArr(List<String> numbers) {

        for (String number : numbers) {
            System.out.printf("%s ", number);
        }
    }

}
