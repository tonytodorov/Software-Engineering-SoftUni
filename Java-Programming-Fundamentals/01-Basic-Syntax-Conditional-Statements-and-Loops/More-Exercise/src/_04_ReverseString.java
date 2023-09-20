import java.util.Scanner;

public class _04_ReverseString {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();
        String result = "";

        for (int i = text.length() - 1; i >= 0; i--) {
            char letter = text.charAt(i);
            result += letter;
        }

        System.out.println(result);
    }
}
