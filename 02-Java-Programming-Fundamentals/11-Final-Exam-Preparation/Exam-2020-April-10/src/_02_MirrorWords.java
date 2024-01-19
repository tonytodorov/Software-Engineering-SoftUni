import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _02_MirrorWords {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();

        Pattern pattern = Pattern.compile("([#@])(?<firstWord>[A-Za-z]{3,})\\1\\1" +
                "(?<secondWord>[A-Za-z]{3,})\\1");
        Matcher matcher = pattern.matcher(text);

        int wordPairsCount = 0;
        List<String> mirrorWords = new ArrayList<>();

        while (matcher.find()) {
            wordPairsCount += 1;

            String firstWord = matcher.group("firstWord");
            String secondWord = new StringBuilder(matcher.group("secondWord")).reverse().toString();

            if (firstWord.equals(secondWord)) {
                mirrorWords.add(firstWord + " <=> " + matcher.group("secondWord"));
            }
        }

        if (wordPairsCount == 0) {
            System.out.println("No word pairs found!");
        } else {
            System.out.printf("%d word pairs found!%n", wordPairsCount);
        }

        if (mirrorWords.isEmpty()) {
            System.out.println("No mirror words!");
        } else {
            System.out.println("The mirror words are:");
            System.out.print(String.join(", ", mirrorWords));
        }
    }
}
