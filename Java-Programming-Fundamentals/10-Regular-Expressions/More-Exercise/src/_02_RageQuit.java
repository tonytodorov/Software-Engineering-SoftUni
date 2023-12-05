import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _02_RageQuit {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine().toUpperCase();

        int uniqueSymbols = uniqueSymbols(text);

        Pattern pattern = Pattern.compile("(?<currentText>[^\\d]+)(?<repeatTimes>[\\d]+)");
        Matcher matcher = pattern.matcher(text);

        StringBuilder result = new StringBuilder();

        while (matcher.find()) {
            String currentText = matcher.group("currentText");
            int repeatTimes = Integer.parseInt(matcher.group("repeatTimes"));

            result.append(String.valueOf(currentText).repeat(Math.max(0, repeatTimes)));
        }

        System.out.printf("Unique symbols used: %d%n", uniqueSymbols);
        System.out.println(result);
    }

    public static int uniqueSymbols(String text) {

        int uniqueSymbols = 0;
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            char letter = text.charAt(i);

            if (!Character.isDigit(letter) && !result.toString().contains(String.valueOf(letter)) && letter != 32) {
                result.append(letter);
                uniqueSymbols += 1;
            }
        }

        return uniqueSymbols;
    }
}
