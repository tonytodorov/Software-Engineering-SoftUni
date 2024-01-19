import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class _06_FixEmails {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();
        Map<String, String> emails = new LinkedHashMap<>();

        while (!command.equals("stop")) {
            String email = scanner.nextLine();

            if (!emails.containsKey(command)) {
                if (!email.contains(".us") && !email.contains(".US")
                        && !email.contains(".uk") && !email.contains(".UK")
                        && !email.contains(".com") && !email.contains(".COM"))
                emails.put(command, email);
            }

            command = scanner.nextLine();
        }

        for (Map.Entry<String, String> entry: emails.entrySet()) {
            System.out.printf("%s -> %s%n", entry.getKey(), entry.getValue());
        }
    }
}
