import java.util.Scanner;

public class NewHouse {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String flower;
        int numberOfFlowers, budget;
        double price;

        flower = scanner.nextLine();
        numberOfFlowers = Integer.parseInt(scanner.nextLine());
        budget = Integer.parseInt(scanner.nextLine());

        if(flower.equals("Roses")){
            price = numberOfFlowers * 5;
            if(numberOfFlowers > 80){
                price *= 0.9;
            }
        }else if (flower.equals("Dahlias")){
            price = numberOfFlowers * 3.8;
            if(numberOfFlowers > 90){
                price *= 0.85;
            }
        }else if (flower.equals("Tulips")){
            price = numberOfFlowers * 2.8;
            if(numberOfFlowers > 80){
                price *= 0.85;
            }
        }else if (flower.equals("Narcissus")){
            price = numberOfFlowers * 3;
            if(numberOfFlowers < 120){
                price = price + (price * 0.15);
            }
        }else{
            price = numberOfFlowers * 2.5;
            if(numberOfFlowers < 80){
                price = price + (price * 0.2);
            }
        }

        if(budget >= price){
            System.out.printf("Hey, you have a great garden with %d %s and %.2f leva left.",
                    numberOfFlowers, flower, budget - price);
        }else{
            System.out.printf("Not enough money, you need %.2f leva more.", price - budget);
        }
    }
}
