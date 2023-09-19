package exam9and10march2019;

import java.util.Scanner;

public class BasketballEquipment {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int yearTax;
        double basketballShoes, basketballTeam, basketballBall, basketballAccessories, totalPrice;
        yearTax = Integer.parseInt(scanner.nextLine());

        basketballShoes = yearTax * 0.6;
        basketballTeam = basketballShoes * 0.8;
        basketballBall = basketballTeam * 0.25;
        basketballAccessories = basketballBall * 0.2;

        totalPrice = yearTax + basketballShoes + basketballTeam + basketballBall + basketballAccessories;

        System.out.printf("%.2f", totalPrice);
    }
}
