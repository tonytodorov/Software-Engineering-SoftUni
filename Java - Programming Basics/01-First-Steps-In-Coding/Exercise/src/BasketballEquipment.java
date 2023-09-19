import java.util.Scanner;

public class BasketballEquipment {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int yearTaxForBasketballTraining;
        double basketballShoes, basketballTeam, basketballBall, basketballAccessories, totalPrice;

        yearTaxForBasketballTraining = scanner.nextInt();
        basketballShoes = yearTaxForBasketballTraining * 0.6;
        basketballTeam = basketballShoes * 0.8;
        basketballBall = basketballTeam * 0.25;
        basketballAccessories = basketballBall * 0.2;

        totalPrice = yearTaxForBasketballTraining + basketballShoes + basketballTeam + basketballBall + basketballAccessories;

        System.out.println(totalPrice);
    }
}
