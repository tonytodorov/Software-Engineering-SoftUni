import java.util.Scanner;

public class FootballKit {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double priceForTShirt, neededMoney, priceForShorts, priceForSocks, priceForShoes, totalPrice;
        priceForTShirt = Double.parseDouble(scanner.nextLine());
        neededMoney = Double.parseDouble(scanner.nextLine());

        priceForShorts = priceForTShirt * 0.75;
        priceForSocks = priceForShorts * 0.2;
        priceForShoes = (priceForTShirt + priceForShorts) * 2;

        totalPrice = priceForTShirt + priceForShorts + priceForSocks + priceForShoes;
        totalPrice *= 0.85;

        if(totalPrice >= neededMoney){
            System.out.printf("Yes, he will earn the world-cup replica ball!%nHis sum is %.2f lv.", totalPrice);
        }else{
            System.out.printf("No, he will not earn the world-cup replica ball.%nHe needs %.2f lv. more.", neededMoney - totalPrice);
        }
    }
}
