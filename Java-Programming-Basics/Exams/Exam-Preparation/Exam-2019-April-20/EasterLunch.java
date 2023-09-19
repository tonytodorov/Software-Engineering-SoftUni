import java.util.Scanner;

public class EasterLunch {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int easterBread, eggsCrust, kilogramCookies;
        double totalPriceForEasterBread, totalPriceForEggsCrust, totalPriceForKilogramCookies, eggColor, totalPrice;

        easterBread = Integer.parseInt(scanner.nextLine());
        eggsCrust = Integer.parseInt(scanner.nextLine());
        kilogramCookies = Integer.parseInt(scanner.nextLine());

        totalPriceForEasterBread = easterBread * 3.2;
        totalPriceForEggsCrust = eggsCrust * 4.35;
        totalPriceForKilogramCookies = kilogramCookies * 5.40;
        eggColor = (eggsCrust * 12) * 0.15;

        totalPrice = totalPriceForEasterBread + totalPriceForEggsCrust + totalPriceForKilogramCookies + eggColor;

        System.out.printf("%.2f", totalPrice);
    }
}
