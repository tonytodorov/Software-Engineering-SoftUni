package card_suit;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        if (input.equals("Card Suits")) {
            System.out.println("Card Suits:");
            Arrays.stream(CardSuit.values())
                    .forEach(cardSuit -> System.out.printf("Ordinal value: %d; Name value: %s%n",
                            cardSuit.getOrdinalValue(), cardSuit));
        }
    }
}
