import java.util.Scanner;

public class PetShop {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfDogFood, numberOfCatFood;
        double priceDogFood, priceCatFood, totalPrice;

        numberOfDogFood = Integer.parseInt(scanner.nextLine());
        numberOfCatFood = scanner.nextInt();

        priceDogFood = numberOfDogFood * 2.5;
        priceCatFood = numberOfCatFood * 4;

        totalPrice = priceDogFood + priceCatFood;

        System.out.println(totalPrice +  " lv.");


    }
}
