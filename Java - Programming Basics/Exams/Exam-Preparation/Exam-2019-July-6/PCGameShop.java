import java.util.Scanner;

public class PCGameShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String nameOfGame;
        int numberOfSellGames,
                countHearthstone = 0,
                countFornite = 0,
                countOverwatch = 0,
                countOthers = 0;
        double p1, p2, p3, p4;
        numberOfSellGames = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= numberOfSellGames; i++) {
            nameOfGame = scanner.nextLine();

            switch (nameOfGame) {
                case "Hearthstone":
                    countHearthstone++;
                    break;
                case "Fornite":
                    countFornite++;
                    break;
                case "Overwatch":
                    countOverwatch++;
                    break;
                default:
                    countOthers++;
                    break;
            }
        }

        p1 = (double)countHearthstone / numberOfSellGames * 100;
        p2 = (double)countFornite / numberOfSellGames * 100;
        p3 = (double)countOverwatch / numberOfSellGames * 100;
        p4 = (double)countOthers / numberOfSellGames * 100;

        System.out.printf("Hearthstone - %.2f%%%nFornite - %.2f%%%nOverwatch - %.2f%%%nOthers - %.2f%%", p1, p2, p3, p4);

    }
}
