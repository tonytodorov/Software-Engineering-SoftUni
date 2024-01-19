import java.util.Locale;
import java.util.Scanner;

public class _01_ActivationKeys {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        String command = scanner.nextLine();

        while (!command.equals("Generate")) {

            String[] tokens = command.split("[>]+");
            String operation = tokens[0];

            if (operation.equals("Contains")) {
                String substr = tokens[1];

                if (input.contains(substr)) {
                    System.out.printf("%s contains %s%n", input, substr);
                } else {
                    System.out.println("Substring not found!");
                }

            } else if (operation.equals("Flip")) {
                String flipType = tokens[1];
                int startIndex = Integer.parseInt(tokens[2]);
                int endIndex = Integer.parseInt(tokens[3]);

                String substr = input.substring(startIndex, endIndex);

                if (flipType.equals("Upper")) {
                    input = input.replace(substr, substr.toUpperCase());
                } else {
                    input = input.replace(substr, substr.toLowerCase());
                }

                System.out.println(input);
            } else if (operation.equals("Slice")) {
                int startIndex = Integer.parseInt(tokens[1]);
                int endIndex = Integer.parseInt(tokens[2]);

                StringBuilder slice = new StringBuilder(input);
                slice.replace(startIndex, endIndex, "");

                input = slice.toString();
                System.out.println(input);
            }

            command = scanner.nextLine();
        }

        System.out.printf("Your activation key is: %s", input);
    }
}
