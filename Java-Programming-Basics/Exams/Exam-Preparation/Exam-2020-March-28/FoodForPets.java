import java.util.Scanner;

public class FoodForPets {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfDays, quantityOfEatingFoodFromDog, quantityOfEatingFoodFromCat,
                sumDogFood = 0, sumCatFood = 0, totalEatingFood = 0;
        double quantityOfFood, quantityOfCookies = 0.00;

        numberOfDays = Integer.parseInt(scanner.nextLine());
        quantityOfFood = Double.parseDouble(scanner.nextLine());

        for (int i = 1; i <= numberOfDays; i++) {
            quantityOfEatingFoodFromDog = Integer.parseInt(scanner.nextLine());
            quantityOfEatingFoodFromCat = Integer.parseInt(scanner.nextLine());

            if(i % 3 == 0){
                quantityOfCookies = Math.round((quantityOfEatingFoodFromDog + quantityOfEatingFoodFromCat) * 0.1);
            }
            sumDogFood += quantityOfEatingFoodFromDog;
            sumCatFood += quantityOfEatingFoodFromCat;

            totalEatingFood = sumDogFood + sumCatFood;
        }

        System.out.printf("Total eaten biscuits: %.0fgr.%n" +
                "%.2f%% of the food has been eaten.%n" +
                "%.2f%% eaten from the dog.%n" +
                "%.2f%% eaten from the cat.",
                quantityOfCookies,
                (totalEatingFood * 100) / quantityOfFood,
                (double)(sumDogFood * 100) / totalEatingFood,
                (double)(sumCatFood * 100) / totalEatingFood);
    }
}
