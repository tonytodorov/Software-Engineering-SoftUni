import java.util.Scanner;

public class TennisEquipment {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double priceForOneTennisRocket, priceForTennisRockets, priceForShoes, totalPrice;
        int numberOfTennisRockets, numberOfShoes;

        priceForOneTennisRocket = Double.parseDouble(scanner.nextLine());
        numberOfTennisRockets = Integer.parseInt(scanner.nextLine());
        numberOfShoes = Integer.parseInt(scanner.nextLine());

        priceForTennisRockets = priceForOneTennisRocket * numberOfTennisRockets;
        priceForShoes = numberOfShoes * (priceForOneTennisRocket / 6);

        totalPrice = ((priceForTennisRockets + priceForShoes) * 0.2) + priceForTennisRockets + priceForShoes;

        System.out.printf("Price to be paid by Djokovic %.0f%n", Math.floor(totalPrice / 8));
        System.out.printf("Price to be paid by sponsors %.0f", Math.ceil(totalPrice * 7 / 8));

    }
}
