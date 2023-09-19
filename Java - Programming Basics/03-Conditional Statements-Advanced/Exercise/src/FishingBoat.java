import java.util.Scanner;

public class FishingBoat {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int budget, numberOfFishers;
        double price;
        String season;

        budget = Integer.parseInt(scanner.nextLine());
        season = scanner.nextLine();
        numberOfFishers = scanner.nextInt();

        if(season.equals("Spring")){
            price = 3000;
            if(numberOfFishers <= 6){
                price *= 0.9;
            }else if(numberOfFishers <= 11){
                price *= 0.85;
            }else{
                price *= 0.75;
            }
            if(numberOfFishers % 2 == 0){
                price *= 0.95;
            }
        }else if(season.equals("Summer") || season.equals("Autumn")){
            price = 4200;
            if(numberOfFishers <= 6){
                price *= 0.9;
            }else if(numberOfFishers <= 11){
                price *= 0.85;
            }else{
                price *= 0.75;
            }
            if(numberOfFishers % 2 == 0 && season.equals("Summer")){
                price *= 0.95;
            }
        }else{
            price = 2600;
            if(numberOfFishers <= 6){
                price *= 0.9;
            }else if(numberOfFishers <= 11){
                price *= 0.85;
            }else{
                price *= 0.75;
            }
            if(numberOfFishers % 2 == 0){
                price *= 0.95;
            }
        }

        if(budget >= price){
            System.out.printf("Yes! You have %.2f leva left.", budget - price);
        }else{
            System.out.printf("Not enough money! You need %.2f leva.", price - budget);
        }
    }
}
