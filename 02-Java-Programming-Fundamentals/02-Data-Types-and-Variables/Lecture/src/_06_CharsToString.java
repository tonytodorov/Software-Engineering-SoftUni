import java.util.Scanner;

public class _06_CharsToString {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < 3; i++) {
            String letter = scanner.nextLine();
            result.append(letter);
        }

        System.out.println(result);
    }
}
