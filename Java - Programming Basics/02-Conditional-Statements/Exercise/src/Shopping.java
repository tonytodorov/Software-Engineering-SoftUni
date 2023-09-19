import java.util.Scanner;

public class Shopping {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double budget, priceForVideoCards, priceForProcessors, priceForRamMemory, totalPriceForProcessors, totalPriceForMemory, totalPrice;
        int videoCards, processors, ramMemory;

        budget = Double.parseDouble(scanner.nextLine());
        videoCards = Integer.parseInt(scanner.nextLine());
        processors = Integer.parseInt(scanner.nextLine());
        ramMemory = scanner.nextInt();

        priceForVideoCards = videoCards * 250;
        priceForProcessors = priceForVideoCards * 0.35;
        totalPriceForProcessors = priceForProcessors * processors;
        priceForRamMemory = priceForVideoCards * 0.10;
        totalPriceForMemory = priceForRamMemory * ramMemory;

        totalPrice = priceForVideoCards + totalPriceForProcessors + totalPriceForMemory;

        if(videoCards > processors){
            totalPrice *= 0.85;
        }

        if(budget >= totalPrice){
            System.out.printf("You have %.2f leva left!", budget - totalPrice);
        }else{
            System.out.printf("Not enough money! You need %.2f leva more!", Math.abs(budget - totalPrice));
        }


    }
}
