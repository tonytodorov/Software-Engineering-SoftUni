import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _01_Train {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> wagons = Arrays.stream(scanner.nextLine()
                .split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int maxCapacity = Integer.parseInt(scanner.nextLine());
        String command = scanner.nextLine();

        while (!command.equals("end")) {
            String[] text = command.split(" ");

            if (text[0].equals("Add")) {
                wagons.add(Integer.parseInt(text[1]));
            } else {
                int passengers = Integer.parseInt(text[0]);

                for (int i = 0; i < wagons.size(); i++) {
                    if(wagons.get(i) + passengers <= maxCapacity) {
                        wagons.set(i, wagons.get(i) + passengers);
                        break;
                    }
                }
            }

            command = scanner.nextLine();
        }

        for (int wagon: wagons) {
            System.out.printf("%d ", wagon);
        }
    }
}
