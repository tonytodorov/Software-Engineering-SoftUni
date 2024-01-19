import java.util.Scanner;

public class CatWalking {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int minutesForWalk, numberOfWalks, calories, totalTimeForWalk, totalCalories;

        minutesForWalk = Integer.parseInt(scanner.nextLine());
        numberOfWalks = Integer.parseInt(scanner.nextLine());
        calories = Integer.parseInt(scanner.nextLine());

        totalTimeForWalk = minutesForWalk * numberOfWalks;
        totalCalories = totalTimeForWalk * 5;
        calories *= 0.5;

        if(totalCalories >= calories){
            System.out.printf("Yes, the walk for your cat is enough. Burned calories per day: %d.", totalCalories);
        }else{
            System.out.printf("No, the walk for your cat is not enough. Burned calories per day: %d.", totalCalories);
        }
    }
}
