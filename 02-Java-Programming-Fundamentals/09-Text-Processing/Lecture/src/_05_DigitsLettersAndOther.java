import java.util.Scanner;

public class _05_DigitsLettersAndOther {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        StringBuilder numbers = new StringBuilder();
        StringBuilder text = new StringBuilder();
        StringBuilder symbols = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            char letter = input.charAt(i);

            if (letter >= 48 && letter <= 57) {
                numbers.append(letter);
            } else if (letter >= 65 && letter <= 90 || letter >= 97 && letter <= 122) {
                text.append(letter);
            } else {
                symbols.append(letter);
            }
        }

        System.out.println(numbers);
        System.out.println(text);
        System.out.println(symbols);
    }
}
