import java.util.Scanner;

public class FruitMarket {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double priceForStrawberries, quantityOfBananas,
                quantityOfOranges, quantityOfRaspberries,
                quantityOfStrawberries, priceForRaspberries,
                priceForOranges, priceForBananas, totalPrice;

        priceForStrawberries = Double.parseDouble(scanner.nextLine());
        quantityOfBananas = Double.parseDouble(scanner.nextLine());
        quantityOfOranges = Double.parseDouble(scanner.nextLine());
        quantityOfRaspberries = Double.parseDouble(scanner.nextLine());
        quantityOfStrawberries = Double.parseDouble(scanner.nextLine());

        priceForRaspberries = priceForStrawberries / 2;
        priceForOranges = priceForRaspberries * 0.6;
        priceForBananas = priceForRaspberries * 0.2;

        priceForBananas *= quantityOfBananas;
        priceForOranges *= quantityOfOranges;
        priceForRaspberries *= quantityOfRaspberries;
        priceForStrawberries *= quantityOfStrawberries;

        totalPrice = priceForBananas + priceForOranges + priceForRaspberries + priceForStrawberries;

        System.out.printf("%.2f", totalPrice);



    }
}
