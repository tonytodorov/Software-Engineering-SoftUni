import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _04_ListOperations {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine()
                .split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        String command = scanner.nextLine();

        while (!command.equals("End")) {

            String[] text = command.split(" ");
            String operation = text[0];

            if (operation.equals("Add")) {
                int number = Integer.parseInt(text[1]);
                numbers.add(number);
            } else if (operation.equals("Insert")) {
                int number = Integer.parseInt(text[1]);
                int index = Integer.parseInt(text[2]);

                boolean isOutOfRange = isOutOfRange(numbers, index);

                if (!isOutOfRange) {
                    numbers.add(index, number);
                }

            } else if (operation.equals("Remove")) {
                int index = Integer.parseInt(text[1]);

                boolean isOutOfRange = isOutOfRange(numbers, index);

                if (!isOutOfRange) {
                    numbers.remove(index);
                }
            } else if (operation.equals("Shift")) {
                String direction = text[1];
                int count = Integer.parseInt(text[2]);

                if (direction.equals("left")) {
                    shiftLeft(numbers, count);
                } else {
                    shiftRight(numbers, count);
                }
            }

            command = scanner.nextLine();
        }

        for (int num: numbers) {
            System.out.printf("%d ", num);
        }
    }


    public static boolean isOutOfRange(List<Integer> numbers, int index) {

        if (index < 0 || index > numbers.size()) {
            System.out.println("Invalid index");
            return true;
        }

        return false;
    }

    public static void shiftLeft(List<Integer> numbers, int count) {

        for (int i = 0; i < count; i++) {
            int temp = numbers.get(0);

            for (int j = 0; j < numbers.size() - 1; j++) {
                numbers.set(j, numbers.get(j + 1));
            }

            numbers.set(numbers.size() - 1, temp);
        }
    }


    public static void shiftRight(List<Integer> numbers, int count) {

        for (int i = 0; i < count; i++) {
            int temp = numbers.get(numbers.size() - 1);

            for (int j = numbers.size() - 1; j > 0; j--) {
                numbers.set(j, numbers.get(j - 1));
            }

            numbers.set(0, temp);
        }
    }
}
