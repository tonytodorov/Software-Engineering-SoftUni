import java.util.Arrays;
import java.util.Scanner;

public class _06_LadyBugs {

    private static final int EMPTY_FIELD = 0;
    private static final int LADYBUG = 1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int length = Integer.parseInt(scanner.nextLine());
        int[] ladybugsPosition = Arrays.stream(scanner.nextLine()
                .split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[] field = new int[length];

        for (int index : ladybugsPosition) {
            if (index >= 0 && index < field.length) {
                field[index] = LADYBUG;
            }
        }

        String command = scanner.nextLine();

        while (!command.equals("end")){
            String[] text = command.split(" ");

            int index = Integer.parseInt(text[0]);
            String direction = text[1];
            int flyLength = Integer.parseInt(text[2]);

            if (index < 0 || index > field.length - 1 || field[index] == EMPTY_FIELD) {
                command = scanner.nextLine();
                continue;
            }

            field[index] = EMPTY_FIELD;

            if (direction.equals("right")) {
                index += flyLength;

                while (index < field.length - 1 && field[index] == LADYBUG) {
                    index += flyLength;
                }

                if (index < field.length) {
                    field[index] = LADYBUG;
                }

            } else {
                index -= flyLength;

                while (index >= 0 && field[index] == LADYBUG) {
                    index -= flyLength;
                }

                if (index >= 0) {
                    field[index] = LADYBUG;
                }
            }

            command = scanner.nextLine();
        }

        for (int ladybug: field) {
            System.out.printf("%d ", ladybug);
        }
    }
}
