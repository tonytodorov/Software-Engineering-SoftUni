import java.util.Arrays;
import java.util.Scanner;

public class _09_ArrayModifier {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine()
                .split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        String command = scanner.nextLine();
        String operation = "";

        while (!command.equals("end")){
            String[] part = command.split(" ");
            operation = part[0];

            if(operation.equals("decrease")){
                for (int i = 0; i < numbers.length; i++) {
                    numbers[i] -= 1;
                }
                command = scanner.nextLine();
                continue;
            }

            int firstIndex = Integer.parseInt(part[1]);
            int secondIndex = Integer.parseInt(part[2]);

            if (operation.equals("swap")){
                int temp = numbers[firstIndex];
                numbers[firstIndex] = numbers[secondIndex];
                numbers[secondIndex] = temp;
            } else if (operation.equals("multiply")){
                int multiply = numbers[firstIndex] * numbers[secondIndex];
                numbers[firstIndex] = multiply;
            }

            command = scanner.nextLine();
        }

        for (int i = 0; i < numbers.length; i++) {
            System.out.printf("%d", numbers[i]);

            if(i < numbers.length - 1){
                System.out.print(", ");
            }
        }
    }
}
