package cards_with_power;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String name = scanner.nextLine();
        String suit = scanner.nextLine();

        Card card = new Card(name, suit);

        System.out.println(card);
    }
}
