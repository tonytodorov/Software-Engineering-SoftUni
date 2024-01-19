import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _06_ValidPassword {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        String regex = "_\\.+(?<password>[A-Z]([A-Za-z0-9]+){4,}[A-Z])_\\.+";

        Pattern pattern = Pattern.compile(regex);

        for (int i = 0; i < n; i++) {
            String password = scanner.nextLine();
            Matcher matcher = pattern.matcher(password);

            if (matcher.find()) {
                StringBuilder result = new StringBuilder();

                for (int j = 0; j < password.length(); j++) {
                    char letter = password.charAt(j);

                    if (Character.isDigit(letter)) {
                        result.append(letter);
                    }
                }

                if (result.length() == 0) {
                    System.out.println("Group: default");
                } else {
                    System.out.printf("Group: %s%n", result);
                }
            } else {
                System.out.println("Invalid pass!");
            }
        }
    }
}
