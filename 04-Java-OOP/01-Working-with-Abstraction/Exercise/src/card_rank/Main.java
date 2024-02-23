package card_rank;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        if (input.equals("Card Ranks")) {
            System.out.println("Card Ranks:");
            Arrays.stream(CardRank.values())
                    .forEach(cardRank -> System.out.printf("Ordinal value: %d; Name value: %s%n",
                    cardRank.getValue(), cardRank));
        }
    }
}
