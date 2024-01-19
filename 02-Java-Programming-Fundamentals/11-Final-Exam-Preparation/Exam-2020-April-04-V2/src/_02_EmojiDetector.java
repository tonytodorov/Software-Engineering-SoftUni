import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _02_EmojiDetector {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();

        Pattern numbers = Pattern.compile("[\\d]");
        Matcher matchNumbers = numbers.matcher(text);

        BigInteger threshold = BigInteger.ONE;

        while (matchNumbers.find()) {
            int number = Integer.parseInt(matchNumbers.group());
            threshold = threshold.multiply(BigInteger.valueOf(number));
        }

        Pattern emojis = Pattern.compile("(\\*\\*|::)(?<emojiName>[A-Z][a-z]{2,})\\1");
        Matcher matchEmojis = emojis.matcher(text);

        int countEmojis = 0;
        List<String> coolEmojis = new ArrayList<>();

        while (matchEmojis.find()) {
            countEmojis += 1;
            String emojiName = matchEmojis.group("emojiName");

            BigInteger sumLetters = BigInteger.ZERO;

            for (int i = 0; i < emojiName.length(); i++) {
                char letter = emojiName.charAt(i);
                sumLetters = sumLetters.add(BigInteger.valueOf(letter));
            }

            int compareValue = sumLetters.compareTo(threshold);

            if (compareValue > 0) {
                coolEmojis.add(matchEmojis.group());
            }
        }

        System.out.printf("Cool threshold: %d%n", threshold);
        System.out.printf("%d emojis found in the text. The cool ones are:%n", countEmojis);

        for (String emoji: coolEmojis) {
            System.out.println(emoji);
        }
    }
}
