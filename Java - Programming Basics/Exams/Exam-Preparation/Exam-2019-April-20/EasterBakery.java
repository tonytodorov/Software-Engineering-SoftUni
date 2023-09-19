package exam20and21april2019;

import java.util.Scanner;

public class EasterBakery {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double priceForFlour, kgForFlour, kgForSugar, sugarPrice,
                priceForEggs, priceForYeast, totalPriceForFlour,
                totalPriceForSugar, totalPriceForEggs, totalPriceForYeast, totalPrice;
        int eggCrust, packageOfYeast;

        priceForFlour = Double.parseDouble(scanner.nextLine());
        kgForFlour = Double.parseDouble(scanner.nextLine());
        kgForSugar = Double.parseDouble(scanner.nextLine());
        eggCrust = Integer.parseInt(scanner.nextLine());
        packageOfYeast = Integer.parseInt(scanner.nextLine());

        sugarPrice = priceForFlour * 0.75;
        priceForEggs = priceForFlour * 1.10;
        priceForYeast = sugarPrice * 0.2;

        totalPriceForFlour = priceForFlour * kgForFlour;
        totalPriceForSugar = sugarPrice * kgForSugar;
        totalPriceForEggs = priceForEggs * eggCrust;
        totalPriceForYeast = priceForYeast *  packageOfYeast;

        totalPrice = totalPriceForFlour + totalPriceForSugar + totalPriceForEggs + totalPriceForYeast;

        System.out.printf("%.2f", totalPrice);

    }
}
