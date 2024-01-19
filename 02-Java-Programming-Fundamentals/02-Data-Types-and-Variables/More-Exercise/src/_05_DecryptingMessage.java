import java.util.Scanner;

public class _05_DecryptingMessage {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int key = Integer.parseInt(scanner.nextLine());
        int n = Integer.parseInt(scanner.nextLine());

        int result;
        String message = "";

        for (int i = 0; i < n; i++) {
            String text = scanner.nextLine();
            char letter = text.charAt(0);

            result = letter + key;
            message += (char) result;
        }

        System.out.println(message);
    }
}
