import java.util.Arrays;
import java.util.Scanner;

public class _02_ArrayModifier {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine()
                .split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        String command = scanner.nextLine();

        while (!command.equals("end")) {

            String[] text = command.split(" ");
            String operation = text[0];

            if (operation.equals("swap")) {
                int firstIndex = Integer.parseInt(text[1]);
                int secondIndex = Integer.parseInt(text[2]);

                int temp = numbers[firstIndex];
                numbers[firstIndex] = numbers[secondIndex];
                numbers[secondIndex] = temp;
            } else if (operation.equals("multiply")) {
                int firstIndex = Integer.parseInt(text[1]);
                int secondIndex = Integer.parseInt(text[2]);

                int result = numbers[firstIndex] * numbers[secondIndex];
                numbers[firstIndex] = result;
            } else if (operation.equals("decrease")) {

                for (int i = 0; i < numbers.length; i++) {
                    numbers[i] -= 1;
                }
            }


            command = scanner.nextLine();
        }


        for (int i = 0; i < numbers.length; i++) {
            System.out.printf("%d", numbers[i]);

            if (i < numbers.length - 1) {
                System.out.print(", ");
            }
        }
        
    }
}
