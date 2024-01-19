import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class _05_Phonebook {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Map<String, String> phonebook = new HashMap<>();

        while (!input.equals("search")) {
            String[] tokens = input.split("-");
            String name = tokens[0];
            String phoneNumber = tokens[1];

            phonebook.put(name, phoneNumber);

            input = scanner.nextLine();
        }

        String command = scanner.nextLine();

        while (!command.equals("stop")) {

            if (phonebook.containsKey(command)) {
                System.out.printf("%s -> %s%n", command, phonebook.get(command));
            } else {
                System.out.printf("Contact %s does not exist.%n", command);
            }

            command = scanner.nextLine();
        }
    }
}
