import java.util.Scanner;

public class PoolDay {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfPeople;
        double priceIn, priceForSunLounger, priceForUmbrella, totalPriceIn,
                totalPriceForSunLounger, totalPriceForUmbrella, totalPrice;

        numberOfPeople = Integer.parseInt(scanner.nextLine());
        priceIn = Double.parseDouble(scanner.nextLine());
        priceForSunLounger = Double.parseDouble(scanner.nextLine());
        priceForUmbrella = Double.parseDouble(scanner.nextLine());

        totalPriceIn = numberOfPeople * priceIn;
        totalPriceForSunLounger = Math.ceil(numberOfPeople * 0.75);
        totalPriceForUmbrella = Math.ceil(numberOfPeople * 0.5);

        totalPrice = totalPriceIn + (totalPriceForSunLounger * priceForSunLounger) + (totalPriceForUmbrella * priceForUmbrella);

        System.out.printf("%.2f lv.", totalPrice);
    }
}
