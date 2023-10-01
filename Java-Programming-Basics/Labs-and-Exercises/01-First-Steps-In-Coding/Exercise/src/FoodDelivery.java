import java.util.Scanner;

public class FoodDelivery {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfChickenMenu, numberOfFishMenu, numberOFVegetarianMenu;
        double priceForChickenMenu, priceForFishMenu, priceForVegetarianMenu, totalPrice, dessertPrice, total, delivery = 2.5;

        numberOfChickenMenu = Integer.parseInt(scanner.nextLine());
        numberOfFishMenu = Integer.parseInt(scanner.nextLine());
        numberOFVegetarianMenu = scanner.nextInt();

        priceForChickenMenu = numberOfChickenMenu * 10.35;
        priceForFishMenu = numberOfFishMenu * 12.40;
        priceForVegetarianMenu = numberOFVegetarianMenu * 8.15;

        totalPrice = priceForChickenMenu + priceForFishMenu + priceForVegetarianMenu;
        dessertPrice = totalPrice * 0.2;

        total = totalPrice + dessertPrice + delivery;

        System.out.println(total);
    }
}
