import java.util.Scanner;

public class EasterGuests {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfGuests, budget;
        double numberOfCakes, numberOfEggs, priceForCake, priceForEggs, totalPrice;
        numberOfGuests = Integer.parseInt(scanner.nextLine());
        budget = Integer.parseInt(scanner.nextLine());

        numberOfCakes = Math.ceil((double)numberOfGuests / 3);
        priceForCake = numberOfCakes * 4;

        numberOfEggs = numberOfGuests * 2;
        priceForEggs = numberOfEggs * 0.45;

        totalPrice = priceForCake + priceForEggs;

        if(budget >= totalPrice){
            System.out.printf("Lyubo bought %.0f Easter bread and %.0f eggs.%nHe has %.2f lv. left.",
                    numberOfCakes, numberOfEggs, budget - totalPrice);
        }else{
            System.out.printf("Lyubo doesn't have enough money.%nHe needs %.2f lv. more.", totalPrice - budget);
        }
    }
}
