import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _03_MovingTarget {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine()
                        .split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        String command = scanner.nextLine();

        while (!command.equals("End")) {

            String[] tokens = command.split(" ");
            String operation = tokens[0];

            if (operation.equals("Shoot")) {
                int index = Integer.parseInt(tokens[1]);
                int power = Integer.parseInt(tokens[2]);

                if (index < 0 || index > numbers.size()) {
                    command = scanner.nextLine();
                    continue;
                }

                if (numbers.get(index) > 0) {
                    numbers.set(index, numbers.get(index) - power);
                }

                if (numbers.get(index) <= 0) {
                    numbers.remove(index);
                }

            } else if (operation.equals("Add")) {
                int index = Integer.parseInt(tokens[1]);
                int value = Integer.parseInt(tokens[2]);

                if (index < 0 || index > numbers.size()) {
                    System.out.println("Invalid placement!");
                    command = scanner.nextLine();
                    continue;
                }

                numbers.add(index, value);

            } else if (operation.equals("Strike")) {
                int index = Integer.parseInt(tokens[1]);
                int radius = Integer.parseInt(tokens[2]);

                int leftIndex = index - radius;
                int rightIndex = index + radius;

                if (leftIndex < 0 || rightIndex > numbers.size()) {
                    System.out.println("Strike missed!");
                    command = scanner.nextLine();
                    continue;
                }

                for (int i = leftIndex; i <= rightIndex; i++) {
                    numbers.remove(leftIndex);
                }
            }

            command = scanner.nextLine();
        }

        printArr(numbers);
    }

    public static void printArr(List<Integer> numbers) {

        for (int i = 0; i < numbers.size(); i++) {
            System.out.printf("%d", numbers.get(i));

            if (i < numbers.size() - 1) {
                System.out.print("|");
            }
        }
    }
}
