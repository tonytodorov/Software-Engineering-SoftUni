import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class _01_TheImitationGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();
        String command = scanner.nextLine();

        while (!command.equals("Decode")) {

            String[] tokens = command.split("\\|");
            String operation = tokens[0];

            if (operation.equals("Move")) {
                text = move(tokens, text);
            } else if (operation.equals("Insert")) {
                text = insert(tokens, text);
            } else if (operation.equals("ChangeAll")) {
                text = changeAll(tokens, text);
            }

            command = scanner.nextLine();
        }

        System.out.printf("The decrypted message is: %s", text);
    }

    public static String move(String[] tokens, String text) {

        int numberOfLetters = Integer.parseInt(tokens[1]);
        String letters = text.substring(0, numberOfLetters);
        text = text.substring(numberOfLetters) + letters;

        return text;
    }

    public static String insert(String[] tokens, String text) {
        int index = Integer.parseInt(tokens[1]);
        String value = tokens[2];

        List<String> result = new ArrayList<>();

        for (int i = 0; i < text.length(); i++) {
            char letter = text.charAt(i);
            String currentLetter = String.valueOf(letter);
            result.add(currentLetter);
        }

        result.add(index, value);
        String newText = "";

        for (String element : result) {
            newText += element;
        }

        text = newText;

        return text;
    }

    public static String changeAll(String[] tokens, String text) {

        String substring = tokens[1];
        String replacement = tokens[2];

        text = text.replace(substring, replacement);

        return text;
    }
}
