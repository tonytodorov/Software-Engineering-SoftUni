import java.util.Scanner;

public class CareOfPuppy {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int quantityOfFoodInKg, quantityOfEatingFood, sumFood = 0;
        String command;
        quantityOfFoodInKg = Integer.parseInt(scanner.nextLine());
        quantityOfFoodInKg *= 1000;

        command = scanner.nextLine();

        while (!command.equals("Adopted")){
            quantityOfEatingFood = Integer.parseInt(command);
            quantityOfFoodInKg -= quantityOfEatingFood;

            command = scanner.nextLine();
        }

        if(quantityOfFoodInKg >= 0){
            System.out.printf("Food is enough! Leftovers: %d grams.", quantityOfFoodInKg);
        }else{
            System.out.printf("Food is not enough. You need %d grams more.", Math.abs(quantityOfFoodInKg));
        }
    }
}
