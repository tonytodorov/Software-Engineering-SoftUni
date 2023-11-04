import java.util.Scanner;

public class _01_RepeatStrings {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();

        while (!text.equals("end")) {
            StringBuilder result = new StringBuilder();

            for (int i = 0; i < text.length(); i++) {
                char letter = text.charAt(i);
                result.insert(0, letter);
            }

            System.out.printf("%s = %s%n", text, result);
            text = scanner.nextLine();
        }
    }
}
