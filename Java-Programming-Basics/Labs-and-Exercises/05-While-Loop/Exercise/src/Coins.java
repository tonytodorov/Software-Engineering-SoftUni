import java.util.Scanner;

public class Coins {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int coinCount = 0;
        double coins, moneyInSt;
        coins = Double.parseDouble(scanner.nextLine());

        moneyInSt = coins * 100;

        while (moneyInSt > 0) {
            if (moneyInSt >= 200) {
                moneyInSt -= 200;
            } else if (moneyInSt >= 100) {
                moneyInSt -= 100;
            } else if (moneyInSt >= 50) {
                moneyInSt -= 50;
            } else if (moneyInSt >= 20) {
                moneyInSt -= 20;
            } else if (moneyInSt >= 10) {
                moneyInSt -= 10;
            } else if (moneyInSt >= 5) {
                moneyInSt -= 5;
            } else if (moneyInSt >= 2) {
                moneyInSt -= 2;
            } else if (moneyInSt >= 1) {
                moneyInSt -= 1;
            }

            coinCount++;
        }
        System.out.println(coinCount);
    }
}
