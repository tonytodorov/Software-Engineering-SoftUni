package grocery;

import grocery.cart.ShoppingCart;
import grocery.payment.Cash;
import grocery.payment.Payment;
import grocery.products.*;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ShoppingCart shoppingCart = new ShoppingCart();

        String command = scanner.nextLine();

        while (!"END".equals(command)) {
            String[] tokens = command.split("\\s+");
            String operation = tokens[0];

            if (operation.equals("Add")) {
                addProduct(shoppingCart, tokens);
            } else if (operation.equals("Remove")) {
                String item = tokens[1];
                shoppingCart.removeProduct(item);
            } else if (operation.equals("GetResult")) {
                System.out.println(shoppingCart.totalCost());
            }

            command = scanner.nextLine();
        }

        Payment payment = new Cash();
        payment.pay();
    }

    private static void addProduct(ShoppingCart shoppingCart, String[] tokens) {
        String item = tokens[1];
        double quantity = Double.parseDouble(tokens[2]);

        switch (item) {
            case "Banana" ->   shoppingCart.addProduct(new Banana(quantity));
            case "Beef" ->     shoppingCart.addProduct(new Beef(quantity));
            case "Bread" ->    shoppingCart.addProduct(new Bread(quantity));
            case "Pork" ->     shoppingCart.addProduct(new Pork(quantity));
            case "Tomato" ->   shoppingCart.addProduct(new Tomato(quantity));
            case "Zucchini" -> shoppingCart.addProduct(new Zucchini(quantity));
        }
    }
}
