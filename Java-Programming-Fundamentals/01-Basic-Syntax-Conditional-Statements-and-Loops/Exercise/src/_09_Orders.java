import java.util.Scanner;

public class _09_Orders {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfOrders = Integer.parseInt(scanner.nextLine());

        double totalPrice = 0.00;

        for (int i = 0; i < numberOfOrders; i++) {
            double pricePerCapsule = Double.parseDouble(scanner.nextLine());
            int day = Integer.parseInt(scanner.nextLine());
            int capsuleCount = Integer.parseInt(scanner.nextLine());

            double currentPrice = pricePerCapsule * day * capsuleCount;
            totalPrice += currentPrice;

            System.out.printf("The price for the coffee is: $%.2f%n", currentPrice);
        }

        System.out.printf("Total: $%.2f", totalPrice);
    }
}
