import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _01_WinningTickets {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();

        Pattern pattern = Pattern.compile("[^\\s+,]+");
        Matcher matcher = pattern.matcher(text);

        List<String> lotteryTickets = new ArrayList<>();

        while (matcher.find()) {
            lotteryTickets.add(matcher.group());
        }


        for (String currentTicket : lotteryTickets) {

            if (currentTicket.length() == 20) {

                String leftSide = currentTicket.substring(0, 10);
                String rightSide = currentTicket.substring(10, 20);

                Pattern symbols = Pattern.compile("[@#$^]+");
                Matcher matchLeft = symbols.matcher(leftSide);
                Matcher matchRight = symbols.matcher(rightSide);

                if (matchLeft.find() && matchRight.find()) {
                    String leftLength = matchLeft.group();
                    String rightLength = matchRight.group();

                    if (leftLength.length() != 10 && rightLength.length() != 10 &&
                            leftLength.length() == rightLength.length()) {
                        System.out.printf("ticket \"%s\" - %s%s%n",
                                currentTicket,
                                leftLength.length(),
                                leftLength.charAt(0));
                    } else {
                        System.out.printf("ticket \"%s\" - %s%s Jackpot!%n",
                                currentTicket,
                                leftLength.length(),
                                leftLength.charAt(0));
                    }
                } else {
                    System.out.printf("ticket \"%s\" - no match%n", currentTicket);
                }

            } else {
                System.out.println("invalid ticket");
            }
        }
    }
}
