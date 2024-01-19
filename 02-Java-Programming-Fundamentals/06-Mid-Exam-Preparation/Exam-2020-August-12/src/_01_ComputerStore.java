import java.util.Scanner;

public class _01_ComputerStore {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();
        double totalPrice = 0.00;
        double tax;
        double priceWithoutTaxes;

        while (!command.equals("special") && !command.equals("regular")) {

            double price = Double.parseDouble(command);

            if (price < 0) {
                System.out.println("Invalid price!");
                command = scanner.nextLine();
                continue;
            }

            totalPrice += price;

            command = scanner.nextLine();
        }

        if (totalPrice == 0) {
            System.out.println("Invalid order!");
            return;
        }

        priceWithoutTaxes = totalPrice;
        tax = totalPrice * 0.2;
        totalPrice *= 1.2;

        if (command.equals("special")) {
            totalPrice *= 0.9;
        }

        System.out.println("Congratulations you've just bought a new computer!");
        System.out.printf("Price without taxes: %.2f$%nTaxes: %.2f$%n", priceWithoutTaxes, tax);
        System.out.println("-----------");
        System.out.printf("Total price: %.2f$", totalPrice);
    }

}
