import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _01_WinningTickets {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] text = scanner.nextLine().split("\\s+,+\\s+");

        for (int i = 0; i < text.length; i++) {
            String currentText = text[i];
            currentText = currentText.replace(",", "");
            text[i] = currentText;
        }

        Pattern checkLength = Pattern.compile(".{20}$");

        for (String element : text) {
            Matcher matcher = checkLength.matcher(element);

            if (matcher.find()) {
                String leftSide = element.substring(0, 10);
                String rightSide = element.substring(10, 20);

                String leftSigns = getSigns(leftSide);
                String rightSigns = getSigns(rightSide);

                if (leftSigns.isEmpty()) {
                    System.out.printf("ticket \"%s\" - no match", element);
                    continue;
                }

                String sign = leftSigns.substring(0, 1);

                if (leftSigns.length() >= 6
                        && leftSigns.length() <= 9
                        && rightSigns.length() >= 6
                        && rightSigns.length() <= 9) {
                    System.out.printf("ticket \"%s\" - %s%s%n", element, leftSigns.length(), sign);
                } else {
                    System.out.printf("ticket \"%s\" - %s%s Jackpot!%n", element, leftSigns.length(), sign);
                }
            } else {
                System.out.println("invalid ticket");
            }
        }
    }

    public static String getSigns(String side) {

        String result = "";

        Pattern pattern = Pattern.compile("(?<winSign>[@#$^]+)");
        Matcher matcher = pattern.matcher(side);

        if (matcher.find()) {
            result = matcher.group("winSign");
        }

        return result;
    }
}
