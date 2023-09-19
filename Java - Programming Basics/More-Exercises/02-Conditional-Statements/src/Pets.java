import java.util.Scanner;

public class Pets {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfDays, foodInKg;
        double foodForDog, foodForCat, foodForTurtle, totalNeededFood;

        numberOfDays = Integer.parseInt(scanner.nextLine());
        foodInKg = Integer.parseInt(scanner.nextLine());
        foodForDog = Double.parseDouble(scanner.nextLine());
        foodForCat = Double.parseDouble(scanner.nextLine());
        foodForTurtle = Double.parseDouble(scanner.nextLine());

        foodForDog *= numberOfDays;
        foodForCat *= numberOfDays;
        foodForTurtle *= (double)numberOfDays / 1000;

        totalNeededFood = Math.ceil(foodForDog + foodForCat + foodForTurtle);

        if(totalNeededFood < foodInKg){
            System.out.printf("%.0f kilos of food left.", foodInKg - totalNeededFood);
        }else{
            System.out.printf("%.0f more kilos of food are needed.", totalNeededFood - foodInKg);
        }
    }
}
