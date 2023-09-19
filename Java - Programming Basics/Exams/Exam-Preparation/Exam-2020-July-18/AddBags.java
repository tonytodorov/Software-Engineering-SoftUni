import java.util.Scanner;

public class AddBags {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double priceForBagsOver20Kg, kgForBags;
        int daysForTravelling, numberOfBags;

        priceForBagsOver20Kg = Double.parseDouble(scanner.nextLine());
        kgForBags = Double.parseDouble(scanner.nextLine());
        daysForTravelling = Integer.parseInt(scanner.nextLine());
        numberOfBags = Integer.parseInt(scanner.nextLine());

        if(kgForBags < 10){
            kgForBags = priceForBagsOver20Kg * 0.2;
        }else if(kgForBags <= 20){
            kgForBags = priceForBagsOver20Kg * 0.5;
        }else if(kgForBags > 20){
            kgForBags = priceForBagsOver20Kg;
        }


        if(daysForTravelling < 7){
            kgForBags *= 1.40;
        }else if(daysForTravelling <= 30){
            kgForBags *= 1.15;
        }

        if(daysForTravelling > 30){
            kgForBags *= 1.10;
        }

        kgForBags *= numberOfBags;
        System.out.printf("The total price of bags is: %.2f lv.", kgForBags);
    }
}
