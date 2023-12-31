import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _07_HandsOfCards {

    private static final int J_POWER = 11;
    private static final int Q_POWER = 12;
    private static final int K_POWER = 13;
    private static final int A_POWER = 14;

    private static final int C_TYPE  = 1;
    private static final int D_TYPE  = 2;
    private static final int H_TYPE  = 3;
    private static final int S_TYPE  = 4;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<String, List<String>> players = new LinkedHashMap<>();

        while (!input.equals("JOKER")) {
            String[] tokens = input.split("(:\\s+)|(,\\s+)");
            String name = tokens[0];

            if (!players.containsKey(name)) {
                players.put(name, new ArrayList<>());
            }

            for (int i = 1; i < tokens.length; i++) {
                String card = tokens[i];

                if (!players.get(name).contains(card)) {
                    players.get(name).add(card);
                }
            }

            input = scanner.nextLine();
        }

        Pattern pattern = Pattern.compile("(?<cardPower>[\\d|JQKA]+)(?<cardType>[SHDC]+)");

        for (Map.Entry<String, List<String>> entry: players.entrySet()) {
            int sum = 0;

            for (String card: entry.getValue()) {
                Matcher matcher = pattern.matcher(card);

                if (matcher.find()) {
                    String cardPower = matcher.group("cardPower");
                    String cardType = matcher.group("cardType");

                    int power = cardPower(cardPower);
                    int type = cardType(cardType);

                    sum += power * type;
                }
            }

            System.out.printf("%s: %d%n", entry.getKey(), sum);
        }
    }

    public static int cardPower(String cardPower) {

        if (cardPower.equals("J")) {
            return J_POWER;
        } else if (cardPower.equals("Q")){
            return Q_POWER;
        } else if (cardPower.equals("K")) {
            return K_POWER;
        } else if (cardPower.equals("A")) {
            return A_POWER;
        } else {
            return Integer.parseInt(cardPower);
        }
    }

    public static int cardType(String cardType) {

        if (cardType.equals("C")) {
            return C_TYPE;
        } else if (cardType.equals("D")) {
            return D_TYPE;
        } else if (cardType.equals("H")) {
            return H_TYPE;
        } else {
            return S_TYPE;
        }
    }
}
