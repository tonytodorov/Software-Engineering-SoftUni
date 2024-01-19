import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _04_SantaSecretHelper {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int key = Integer.parseInt(scanner.nextLine());
        String message = scanner.nextLine();

        List<String> decryptMessages = new ArrayList<>();

        while (!message.equals("end")) {

            StringBuilder decryptedMessage = new StringBuilder();

            for (int i = 0; i < message.length(); i++) {
                char letter = (char) (message.charAt(i) - key);
                decryptedMessage.append(letter);
            }

            decryptMessages.add(decryptedMessage.toString());
            message = scanner.nextLine();
        }

        Pattern pattern = Pattern.compile("@(?<childName>[A-Za-z]+)([^-@!:>])*!([G])!");

        for (String currentMessage : decryptMessages) {
            Matcher matcher = pattern.matcher(currentMessage);

            if (matcher.find()) {
                System.out.println(matcher.group("childName"));
            }
        }
    }
}
