import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _04_ListManipulationBasics {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine()
                .split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        String command = scanner.nextLine();

        while (!command.equals("end")) {
            String[] text = command.split(" ");
            String operation = text[0];

            if (operation.equals("Add")) {
                int number = Integer.parseInt(text[1]);
                numbers.add(number);
            } else if (operation.equals("Remove")) {
                int number = Integer.parseInt(text[1]);
                numbers.remove(Integer.valueOf(number));
            } else if (operation.equals("RemoveAt")) {
                int index = Integer.parseInt(text[1]);
                numbers.remove(index);
            } else {
                int number = Integer.parseInt(text[1]);
                int index = Integer.parseInt(text[2]);
                numbers.add(index, number);
            }

            command = scanner.nextLine();
        }

        for (int num: numbers) {
            System.out.printf("%d ", num);
        }
    }
}
