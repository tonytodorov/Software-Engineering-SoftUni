import java.util.Scanner;

public class _07_ReversedChars {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < 3; i++) {
            String letter = scanner.nextLine();
            char text = letter.charAt(0);
            result.insert(0, text + " ");
        }

        System.out.println(result);
    }
}
