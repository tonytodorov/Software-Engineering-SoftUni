import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _02_MessageDecrypted {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Pattern pattern = Pattern.compile("^([$%])(?<name>[A-Z][a-z]{2,})\\1\\: (\\[" +
                "(?<firstLetter>\\d+)\\])(\\|\\[" +
                "(?<secondLetter>\\d+)\\])(\\|\\[" +
                "(?<thirdLetter>\\d+)\\]\\|)$");

        for (int i = 0; i < n; i++) {
            String message = scanner.nextLine();
            Matcher matcher = pattern.matcher(message);

            if (matcher.find()) {
                String name = matcher.group("name");
                char firstLetter = (char) Integer.parseInt(matcher.group("firstLetter"));
                char secondLetter = (char) Integer.parseInt(matcher.group("secondLetter"));
                char thirdLetter = (char) Integer.parseInt(matcher.group("thirdLetter"));

                String first = String.valueOf(firstLetter);
                String second = String.valueOf(secondLetter);
                String third = String.valueOf(thirdLetter);

                System.out.printf("%s: %s%n", name, first + second + third);
            } else {
                System.out.println("Valid message not found!");
            }
        }
    }
}
