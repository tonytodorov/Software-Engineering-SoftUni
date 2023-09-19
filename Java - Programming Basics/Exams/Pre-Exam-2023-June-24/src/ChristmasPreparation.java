import java.util.Scanner;

public class ChristmasPreparation {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfWrappingPaper, numberOfRollFabric, discount;
        double litersGlue, priceForWrappingPaper, priceForRollFabric, priceForGlue, totalPrice;

        numberOfWrappingPaper = Integer.parseInt(scanner.nextLine());
        numberOfRollFabric = Integer.parseInt(scanner.nextLine());
        litersGlue = Double.parseDouble(scanner.nextLine());
        discount = Integer.parseInt(scanner.nextLine());

        priceForWrappingPaper = numberOfWrappingPaper * 5.8;
        priceForRollFabric = numberOfRollFabric * 7.2;
        priceForGlue = litersGlue * 1.2;

        totalPrice = priceForWrappingPaper + priceForRollFabric + priceForGlue;
        totalPrice = totalPrice - (totalPrice * discount / 100);

        System.out.printf("%.3f", totalPrice);

    }
}
