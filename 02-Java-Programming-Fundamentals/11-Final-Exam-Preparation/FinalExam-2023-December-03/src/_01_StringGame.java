import java.util.Locale;
import java.util.Scanner;

public class _01_StringGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();

        String command = scanner.nextLine();

        while (!command.equals("Done")) {

            String[] tokens = command.split(" ");
            String operation = tokens[0];

            if (operation.equals("Change")) {
                String currentChar = tokens[1];
                String replacement = tokens[2];

                text = text.replace(currentChar, replacement);
                System.out.println(text);
            } else if (operation.equals("Includes")) {
                String substring = tokens[1];

                if (text.contains(substring)) {
                    System.out.println("True");
                } else {
                    System.out.println("False");
                }
            } else if (operation.equals("End")) {
                String substring = tokens[1];

                if (text.endsWith(substring)) {
                    System.out.println("True");
                } else {
                    System.out.println("False");
                }
            } else if (operation.equals("Uppercase")) {
                text = text.toUpperCase();
                System.out.println(text);
            } else if (operation.equals("FindIndex")) {
                String currentChar = tokens[1];
                int index = text.indexOf(currentChar);
                System.out.println(index);
            } else if (operation.equals("Cut")) {
                int startIndex = Integer.parseInt(tokens[1]);
                int count = Integer.parseInt(tokens[2]);

                String currentText = text.substring(startIndex, startIndex + count);
                System.out.println(currentText);
            }

            command = scanner.nextLine();
        }
    }
}
