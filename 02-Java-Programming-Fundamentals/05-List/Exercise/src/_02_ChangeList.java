import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _02_ChangeList {

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

            int element = Integer.parseInt(text[1]);

            if(operation.equals("Delete")) {
                numbers.removeAll(Collections.singleton(element));
            } else {
                int position = Integer.parseInt(text[2]);
                numbers.add(position, element);
            }

            command = scanner.nextLine();
        }


        for (int num: numbers) {
            System.out.printf("%d ", num);
        }
    }
}
