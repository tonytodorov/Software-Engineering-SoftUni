import java.util.Scanner;

public class SmallShop {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String product, city;
        double quantity, price = 0;

        product = scanner.nextLine();
        city = scanner.nextLine();
        quantity = scanner.nextDouble();

        if(city.equals("Sofia")){
            price = switch (product) {
                case "coffee" -> quantity * 0.5;
                case "water" -> quantity * 0.8;
                case "beer" -> quantity * 1.2;
                case "sweet" -> quantity * 1.45;
                default -> quantity * 1.6;
            };
        }

        if(city.equals("Plovdiv")) {
            price = switch (product) {
                case "coffee" -> quantity * 0.4;
                case "water" -> quantity * 0.7;
                case "beer" -> quantity * 1.15;
                case "sweet" -> quantity * 1.30;
                default -> quantity * 1.5;
            };
        }

        if(city.equals("Varna")) {
            price = switch (product) {
                case "coffee" -> quantity * 0.45;
                case "water" -> quantity * 0.7;
                case "beer" -> quantity * 1.10;
                case "sweet" -> quantity * 1.35;
                default -> quantity * 1.55;
            };
        }

        System.out.println(price);
    }
}
