import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class _01_ValidUsernames {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] usernames = scanner.nextLine().split(", ");

        List<String> result = new ArrayList<>();

        for (String currentUsername : usernames) {

            boolean isLengthValid = isLengthValid(currentUsername);

            if (isLengthValid) {
                boolean isUsernameValid = isUsernameValid(currentUsername);

                if (isUsernameValid) {
                    result.add(currentUsername);
                }
            }
        }

        for (String username: result) {
            System.out.println(username);
        }
    }

    public static boolean isLengthValid(String username) {
        return username.length() > 3 && username.length() < 16;
    }

    public static boolean isUsernameValid(String username) {

        for (int i = 0; i < username.length(); i++) {
            char letter = username.charAt(i);

            if (!Character.isLetterOrDigit(letter) && letter != '-' && letter != '_') {
                return false;
            }
        }

        return true;
    }

}
