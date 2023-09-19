import java.util.Scanner;

public class VegetableMarket {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double priceForVegetables, priceForFruits, priceInEuro;
        int kgVegetables, kgFruits;

        priceForVegetables = Double.parseDouble(scanner.nextLine());
        priceForFruits = Double.parseDouble(scanner.nextLine());
        kgVegetables = Integer.parseInt(scanner.nextLine());
        kgFruits = Integer.parseInt(scanner.nextLine());

        priceForVegetables *= kgVegetables;
        priceForFruits *= kgFruits;

        priceInEuro = (priceForVegetables + priceForFruits) / 1.94;

        System.out.printf("%.2f", priceInEuro);
    }
}
