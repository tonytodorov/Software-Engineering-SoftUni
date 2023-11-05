import java.util.Scanner;


public class _04_TextFilter {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] bannedWords = scanner.nextLine().split(", ");

        String text = scanner.nextLine();

        for (String word: bannedWords) {

            int wordSize = word.length();
            StringBuilder result = new StringBuilder();
            result.append("*".repeat(wordSize));

            text = text.replace(word, result);
        }

        System.out.println(text);

    }
}
