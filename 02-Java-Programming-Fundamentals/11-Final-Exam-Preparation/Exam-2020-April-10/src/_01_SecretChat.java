import java.util.Scanner;

public class _01_SecretChat {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();
        String command = scanner.nextLine();

        while (!command.equals("Reveal")) {

            String[] tokens = command.split("[:\\|]+");
            String operation = tokens[0];

            if (operation.equals("InsertSpace")) {
                int index = Integer.parseInt(tokens[1]);

                String left = text.substring(0, index);
                String right = text.substring(index);

                text = left + " " + right;
            } else if (operation.equals("Reverse")){
                String substring = tokens[1];

                if (text.contains(substring)) {
                    text = text.replace(substring, "");

                    String result = "";

                    for (int i = substring.length() - 1; i >= 0; i--) {
                        char letter = substring.charAt(i);
                        result += letter;
                    }

                    text += result;

                } else {
                    System.out.println("error");
                    command = scanner.nextLine();
                    continue;
                }
            } else if (operation.equals("ChangeAll")) {
                String substring = tokens[1];
                String replacement = tokens[2];

                text = text.replaceAll(substring, replacement);
            }

            System.out.println(text);
            command = scanner.nextLine();
        }

        System.out.printf("You have a new text message: %s", text);

    }
}
