import java.util.Scanner;

public class GodzillaVSKong {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double budget, numberOfStatist, priceForClothing, priceForWearing, priceForDecor, totalMoney;
        budget = Double.parseDouble(scanner.nextLine());
        numberOfStatist = Double.parseDouble(scanner.nextLine());
        priceForClothing = Double.parseDouble(scanner.nextLine());

        priceForDecor = budget * 0.1;
        priceForWearing = numberOfStatist * priceForClothing;
        if(numberOfStatist > 150){
            priceForWearing *= 0.9;
        }
        totalMoney = priceForDecor + priceForWearing;

        if(totalMoney > budget){
            System.out.printf("Not enough money!%nWingard needs %.2f leva more.", totalMoney - budget);
        }else{
            System.out.printf("Action!%nWingard starts filming with %.2f leva left.", budget - totalMoney);
        }
    }
}
