import java.util.Scanner;

public class FlowerShop {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfMagnolia, numberOfHyacinth, numberOfRoses, numberOfCactus;
        double priceForGift, totalPrice, priceForMagnolia, priceForHyacinth, priceForRoses, priceForCactus;

        numberOfMagnolia = Integer.parseInt(scanner.nextLine());
        numberOfHyacinth = Integer.parseInt(scanner.nextLine());
        numberOfRoses = Integer.parseInt(scanner.nextLine());
        numberOfCactus = Integer.parseInt(scanner.nextLine());
        priceForGift = Double.parseDouble(scanner.nextLine());

        priceForMagnolia = numberOfMagnolia * 3.25;
        priceForHyacinth = numberOfHyacinth * 4;
        priceForRoses = numberOfRoses * 3.5;
        priceForCactus = numberOfCactus * 8;

        totalPrice = (priceForMagnolia + priceForHyacinth + priceForRoses + priceForCactus) * 0.95;
        totalPrice -= priceForGift;

        if(totalPrice > 0){
            System.out.printf("She is left with %.0f leva.", Math.floor(totalPrice));
        }else{
            System.out.printf("She will have to borrow %.0f leva", Math.abs(Math.ceil(totalPrice)));
        }
    }
}
