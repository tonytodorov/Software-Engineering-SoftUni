import java.util.Scanner;

public class _05_Orders {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String product = scanner.nextLine();
        int quantity = Integer.parseInt(scanner.nextLine());

        double totalPrice = totalPrice(product, quantity);
        System.out.printf("%.2f", totalPrice);

    }

    public static double totalPrice(String product, int quantity){

        double productPrice = 0.00;

        if (product.equals("coffee")) {
           productPrice = 1.50;
        } else if (product.equals("water")) {
            productPrice = 1.00;
        } else if (product.equals("coke")) {
            productPrice = 1.40;
        } else if (product.equals("snacks")) {
            productPrice = 2.00;
        }

        return productPrice * quantity;
    }
}
