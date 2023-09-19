import java.util.Scanner;

public class Fishland {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double priceForKgMackerel, priceForKgSprinkle, kgBonito, kgSafrid,
                priceForBonito, priceForSafrid, priceForMussels, totalPrice;
        int kgMussels;

        priceForKgMackerel = Double.parseDouble(scanner.nextLine());
        priceForKgSprinkle = Double.parseDouble(scanner.nextLine());
        kgBonito = Double.parseDouble(scanner.nextLine());
        kgSafrid = Double.parseDouble(scanner.nextLine());
        kgMussels = Integer.parseInt(scanner.nextLine());

        priceForBonito = (priceForKgMackerel * 1.6) * kgBonito;
        priceForSafrid = (priceForKgSprinkle * 1.8) * kgSafrid;
        priceForMussels = (kgMussels * 7.5);

        totalPrice = priceForBonito + priceForSafrid + priceForMussels;

        System.out.printf("%.2f", totalPrice);

    }
}
