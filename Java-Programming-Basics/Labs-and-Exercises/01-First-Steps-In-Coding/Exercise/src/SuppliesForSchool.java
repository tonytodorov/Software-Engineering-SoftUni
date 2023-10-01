import java.util.Scanner;

public class SuppliesForSchool {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfPackagePens, numberOfPackageMarkers, litersOfWhiteboardCleaner, discount;
        double priceForPens, priceForMarkers, priceForCleaner, totalPrice, totalPriceWithDiscount;

        numberOfPackagePens = Integer.parseInt(scanner.nextLine());
        numberOfPackageMarkers = Integer.parseInt(scanner.nextLine());
        litersOfWhiteboardCleaner = Integer.parseInt(scanner.nextLine());
        discount = Integer.parseInt(scanner.nextLine());

        priceForPens = numberOfPackagePens * 5.80;
        priceForMarkers = numberOfPackageMarkers * 7.20;
        priceForCleaner = litersOfWhiteboardCleaner * 1.20;

        totalPrice = priceForPens + priceForMarkers + priceForCleaner;
        totalPriceWithDiscount = totalPrice - (totalPrice * discount / 100);

        System.out.println(totalPriceWithDiscount);
    }
}
