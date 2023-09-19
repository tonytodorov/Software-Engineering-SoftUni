import java.util.Scanner;

public class CoffeeMachine {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String drink, typeOfSugar;
        int numberOfDrinks;
        double price = 0.00;

        drink = scanner.nextLine();
        typeOfSugar = scanner.nextLine();
        numberOfDrinks = Integer.parseInt(scanner.nextLine());

        if(drink.equals("Espresso")){
            switch (typeOfSugar) {
                case "Without":
                    price = numberOfDrinks * 0.9;
                    price *= 0.65;
                    break;
                case "Normal":
                    price = numberOfDrinks;
                    break;
                case "Extra":
                    price = numberOfDrinks * 1.2;
                    break;
            }
            if(numberOfDrinks > 5){
                price *= 0.75;
            }

        }

        if(drink.equals("Cappuccino")){
            switch (typeOfSugar) {
                case "Without":
                    price = numberOfDrinks;
                    price *= 0.65;
                    break;
                case "Normal":
                    price = numberOfDrinks * 1.2;
                    break;
                case "Extra":
                    price = numberOfDrinks * 1.6;
                    break;
            }
        }

        if(drink.equals("Tea")){
            switch (typeOfSugar) {
                case "Without":
                    price = numberOfDrinks * 0.5;
                    price *= 0.65;
                    break;
                case "Normal":
                    price = numberOfDrinks * 0.6;
                    break;
                case "Extra":
                    price = numberOfDrinks * 0.7;
                    break;
            }
        }

        if(price > 15){
            price *= 0.8;
        }

        System.out.printf("You bought %d cups of %s for %.2f lv.", numberOfDrinks, drink, price);

    }
}
