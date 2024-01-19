import java.util.Scanner;

public class _01_PasswordReset {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        String command = scanner.nextLine();

        while (!command.equals("Done")) {

            String[] tokens = command.split("\\s+");
            String operation = tokens[0];

            if (operation.equals("TakeOdd")) {
                StringBuilder newText = new StringBuilder();

                for (int i = 0; i < input.length(); i++) {
                    if (i % 2 != 0) {
                        char letter = input.charAt(i);
                        newText.append(letter);
                    }
                }

                input = newText.toString();
            } else if (operation.equals("Cut")) {
                int startIndex = Integer.parseInt(tokens[1]);
                int length = Integer.parseInt(tokens[2]);

                int endIndex = startIndex + length;

                String part = input.substring(startIndex, endIndex);
                input = input.replaceFirst(part, "");
            } else if (operation.equals("Substitute")) {
                String substring = tokens[1];
                String substitute = tokens[2];

                if (input.contains(substring)) {
                    input = input.replace(substring, substitute);
                } else {
                    System.out.println("Nothing to replace!");
                    command = scanner.nextLine();
                    continue;
                }
            }

            System.out.println(input);
            command = scanner.nextLine();
        }

        System.out.printf("Your password is: %s", input);
    }
}
