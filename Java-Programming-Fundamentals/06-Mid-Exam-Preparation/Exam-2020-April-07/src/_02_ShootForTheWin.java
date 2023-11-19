import java.util.Arrays;
import java.util.Scanner;

public class _02_ShootForTheWin {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine()
                        .split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        String command = scanner.nextLine();
        int shoots = 0;

        while (!command.equals("End")) {

            int index = Integer.parseInt(command);

            if (index < 0 || index > numbers.length - 1) {
                command = scanner.nextLine();
                continue;
            }

            shoots++;

            int currentNumber = numbers[index];
            numbers[index] = -1;

            for (int i = 0; i < numbers.length; i++) {
                if (numbers[i] != -1 && numbers[i] > currentNumber) {
                    numbers[i] -= currentNumber;
                } else if (numbers[i] != -1 && numbers[i] <= currentNumber) {
                    numbers[i] += currentNumber;
                }
            }

            command = scanner.nextLine();
        }

        System.out.printf("Shot targets: %d -> ", shoots);
        printArr(numbers);
    }

    public static void printArr(int[] numbers) {

        for (int number : numbers) {
            System.out.printf("%d ", number);
        }
    }
}
